'''
658 Find K Closest Elements
https://leetcode.com/problems/find-k-closest-elements/description/

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,1,2,3,4,5], k = 4, x = -1
Output: [1,1,2,3]

Constraints:
1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104

Solution:
1. Brute Force
Find the difference between each element in the array and x. Sort the differences. From the sorted difference array, return the first k elements.
Time: O(N log N), Space: O(N)

2. Two-pointer
Set start = 0, end = N-1, L = len between start and end = N
while L > k:
    Compute d1 = abs(arr[start]-x), d2 = abs(arr[end]-x)
    if d2 >= d1:
        end =- 1 # Move the end pointer to the left
    else #d1 > d2:
        start += 1 # Move the start pointer to the right
    Compute L = end - start + 1
https://youtu.be/sWel_uIgUlY?t=508
Time: O(N), Space: O(1)

3. Binary Search + Two Pointer
Peform a binary search to find the element in the array closest to x. The element in the array may or may not be equal to x.
Then, using a left and right pointer, decrease left by 1 or increase right by 1
until there are k elements between left and right pointer.
Time: O(log N + K), Space: O(1)

3. Binary Search
This is a smarter binary search which doesn't require an additional two pointer technique. With this search, we are trying to get the starting point of a window (of len k) in the original array which contains the k-closest element to x. Note that there are two variations of binary search:
type 1: while (low <= high) --> high = mid - 1
type 2: while (low < high) --> high = mid
We use Type 2 for this problem. The type we use depends on the nature of the problem.
https://youtu.be/sWel_uIgUlY?t=1583
Time: O(log (N-k) + k), Space: O(1)
'''

def findClosestElements_TwoPointer(arr, k, x):
    ''' Solution #2
        Time: O(N), Space: O(1)
    '''
    if not arr:
        return []
    N = len(arr)
    start, end = 0, N-1
    L = end - start + 1
    while L > k and end < N:
        d_start = abs(arr[start] - x)
        d_end   = abs(arr[end] - x)
        if d_start <= d_end:
            end -= 1
        else:
            start += 1
        L = end - start + 1
    result = arr[start:end+1].copy() # T: O(N), Space: O(1)
    return result

def findClosestElements_BinarySearch(arr, k, x):
    ''' Solution #4
        Time: O(log (N-k)) + O(k), Space: O(1)
    '''
    if not arr:
        return []
    N = len(arr)
    low, high = 0, N - k
    # high = N-k since we are trying to find the stating index of a k-len
    # window and the starting index cannot be more than N-k.
    # If starting point = N - k + 1 = N-(k-1), then to fit k-elements,
    # we have to use the window  = [N-(k-1), ..., N-(1), N-(0)].
    # The last index of this window has exceed the last index of the array
    # which is N-1.
    while low < high: # O(N-K)
        mid = low + (high - low)//2

        dist_S = abs(x - arr[mid]) # dist between start of window and x
        dist_E = abs(x - arr[mid+k]) # dist between end of window and x
        # note: to compute dist_high, we use the last element as arr[mid+k] and # not arr[mid+k-1]. Why?
        # Note that no. of elements between mid and mid+k = k+1 whereas the no. # of elements between mid and mid+k-1 = k. But we still use arr[mid+k]
        # because if there is a tie between dist_S and dist_E, then we have
        # the flexibility to discard arr[mid+k] and still retain k elements.
        # We discard the greater element arr[mid+k] instead of the smmaler
        # element arr[mid] because by problem definiton we have to retain
        # the smaller element: |a - x| == |b - x| and a < b

        if dist_S > dist_E:
            low = mid + 1
        else:
            high = mid
            # we don't use high = mid-1 because the while() tests on low < high

    result = arr[low:high+k].copy() # O(K)
    return result

def run_findClosestElements():
    tests = [([1,2,3,4,5], 4, 3, [1,2,3,4]), # x in array
             ([1,1,2,3,4,5], 4, -1, [1,1,2,3]), # x < max(array)
             ([1,4,5,6,7,8,15,16,17], 4, 6, [4,5,6,7]), # x in array
             ([1,4,5,6,7,8,15,16,17], 4, 10, [5,6,7,8]), # x not in array
             ([1,4,5,6,7,8,15,16,17], 4, 18, [8,15,16,17]), # x > max(array)
             ([1,4,5,6,7,8,15,16,17], 4, -2, [1,4,5,6]),    # x < min(array)
    ]
    for test in tests:
        arr, k, x, ans = test[0], test[1], test[2], test[3]
        print(f"\nArray = {arr}")
        print(f"x = {x}, k = {k}")
        for method in ['two-pointer', 'binary-search']:
            if method == 'two-pointer':
                result = findClosestElements_TwoPointer(arr, k, x)
            elif method  == "binary-search":
                result = findClosestElements_BinarySearch(arr, k, x)
            print(f"Method {method}: Result = {result}")
            success = (ans == result)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_findClosestElements()