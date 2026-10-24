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
Find the difference between x and each element in the array. Sort the differences array. From the sorted difference array, return the first k elements.
Time: O(N log N), Space: O(N)

2. Heap
Similar to Brute force but we use a max heap of size K to find the
smallest K elements
Time: O((N+K)log K), Space: O(N)

3. Two-pointer
Set start = 0, end = N-1, L = len between start and end = N
while L > k:
    Compute d1 = abs(arr[start]-x), d2 = abs(arr[end]-x)
    if d2 >= d1:
        end -= 1 # Move the end pointer to the left
    else #d1 > d2:
        start += 1 # Move the start pointer to the right
    Compute L = end - start + 1
https://youtu.be/sWel_uIgUlY?t=508
Time: O(N-K + K) = O(N), Space: O(1)

4. Binary Search + Two Pointer
Peform a binary search to find the element in the array closest to x. The element in the array may or may not be equal to x.
Then, using a left and right pointer, decrease left by 1 or increase right by 1
until there are k elements between left and right pointer.
Time: O(log N + K), Space: O(1)

5. Smart Binary Search
This is a smarter binary search which doesn't require an additional two pointer technique. With this search, we are trying to get the starting point of a window (of len k) in the original array which contains the k-closest element to x. Note that there are two variations of binary search:
type 1: while (low <= high) --> high = mid - 1
type 2: while (low < high) --> high = mid
We use Type 2 for this problem. The type we use depends on the nature of the problem.
https://youtu.be/sWel_uIgUlY?t=1583
Time: O(log (N-k) + k), Space: O(1)
'''
import heapq

def findClosestElements_Heap(arr, k, x):
    '''
    Heap
    Time: N log K + K log K = (N + K) log K, Space: O(K)
    '''
    class MaxHeap:
        def __init__(self, val, x):
            self.val = val
            self.x = x
            self.dist = -1

        def __lt__(self, other):
            d1 = abs(x - self.val)
            d2 = abs(x - other.val)
            self.dist = d1
            if d1 != d2:
                # We want the FARTHEST element to have highest priority
                # so it sits at the top of the max-heap to be evicted.
                return d1 > d2
            else: # d1 == d2
                # Tie-breaker: If distances are equal, the LARGER value
                # is worse and should sit at the top to be evicted.
                return self.val > other.val

    if not arr:
        return []
    N = len(arr)
    heap = []
    for i in range(N):
        num = arr[i]
        hsz = len(heap)

        if hsz < k:
            heapq.heappush(heap, MaxHeap(num, x))
        else:
            heapq.heappushpop(heap, MaxHeap(num, x))
        result = [item.val for item in heap]

        # Note: An alternative to using MaxHeap() class
        # is: heapq.heappush(heap, (-dist, -num)):
        # dist = abs(num - x)
        # if hsz < k:
        #     heapq.heappush(heap, (-dist, -num))
        # else:
        #     heapq.heappushpop(heap, (-dist, -num))
        # result = [-item[-1] for item in heap]

    result.sort()
    return result


def findClosestElements_TwoPointer(arr, k, x):
    ''' Two Pointer
        Time: O(N), Space: O(1)
    '''
    if not arr:
        return []
    N = len(arr)
    start, end = 0, N-1
    L = end - start + 1 # L = len of window
    while L > k:
        dist_S = x - arr[start]
        dist_E = arr[end] - x
        if dist_E >= dist_S:
            end -= 1
        else:
            start += 1
        L = end - start + 1
    return arr[start:end+1].copy()


def findClosestElements_BinarySearch(arr, k, x):
    ''' Binary Search (most optimal solution)
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

        dist_S = x - arr[mid] # dist between start of window and x
        dist_E = arr[mid+k] - x # dist between end of window and x
        # note: to compute dist_high, we use the last element as arr[mid+k] and # not arr[mid+k-1]. Why?
        # Because if there is a tie between dist_S and dist_E, then we have
        # the flexibility to discard arr[mid+k] and still retain k elements
        # from a[mid] to a[mid+k-1].
        # We discard the greater element arr[mid+k] instead of the smaller
        # element arr[mid] because by problem definiton we have to retain
        # the smaller element: |a - x| == |b - x| and a < b

        if dist_S > dist_E:
            low = mid + 1
        else:
            high = mid
            # we don't use high = mid-1 because the while() tests on low < high

    result = arr[low:low+k].copy() # O(K)
    return result

def run_tests():
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
        for method in ['heap', 'two-pointer', 'binary-search']:
            if method == 'two-pointer':
                result = findClosestElements_TwoPointer(arr, k, x)
            elif method  == "binary-search":
                result = findClosestElements_BinarySearch(arr, k, x)
            elif method == 'heap':
                result = findClosestElements_Heap(arr, k, x)

            print(f"Method {method}: Result = {result}")
            passed = (ans == result)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}\n")
    print(f"\nDONE")
run_tests()