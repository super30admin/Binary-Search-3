'''
## Problem 658: Find k closest elements

## Author: Neha Doiphode
## Date:   06-11-2022

## Description:
    Given a sorted integer array arr, two integers k and x,
    return the k closest integers to x in the array.
    The result should also be sorted in ascending order.

    An integer a is closer to x than an integer b if:
        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b

## Examples:
    Example 1:
        Input: arr = [1,2,3,4,5], k = 4, x = 3
        Output: [1,2,3,4]

    Example 2:
        Input: arr = [1,2,3,4,5], k = 4, x = -1
        Output: [1,2,3,4]

## Constraints:
    1 <= k <= arr.length
    1 <= arr.length <= 104
    arr is sorted in ascending order.
    -104 <= arr[i], x <= 104

## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.
'''
from typing import List, Optional

def get_input():
    print("Enter the list of integers(with spaces): ", end = "")
    inp = input()
    inp = [int(val) for val in inp.split()]
    print("Enter the element you want to find closest elements to(x): ", end = "")
    x = int(input())
    print(f"How many integers closest to {x} you want to find(k)?: ", end = "")
    k = int(input())
    return inp, x, k

class Solution:
    def findClosestElements_custom_comparator(self, arr: List[int], k: int, x: int) -> List[int]:
        '''
        Time complexity: O(n log n), O(n) to calculate the difference
                                     O(nlog n) to sort based on abs(x - arr[i])
                                     O(k) to gather k elements
                                     O(klog k) to sort the result array

        Space complexity: O(n) to store the distance of each arr[i] from x.
        '''
        if len(arr) == 0 or len(arr) < k or k < 0:
            return []

        difference = []

        for index, val in enumerate(arr):
            l = []
            diff = abs(val - x)
            l = [diff, index]
            difference.append(l)

        difference.sort()

        result = []
        for diff, index in difference:
            if len(result) == k:
                break
            result.append(arr[index])

        result.sort()

        return result

    def findClosestElements_lambda_function(self, arr: List[int], k: int, x: int) -> List[int]:
        '''
        Time complexity: O(n log n) to sort the array based on custom comparator and O(k log k) to sort the result array.
        Space complexity: O(n) to store the distance of each arr[i] from x.
        '''
        if len(arr) == 0 or len(arr) < k or k < 0:
            return []

        difference = []
        difference = sorted(arr, key = lambda val : abs(val - x))
        return sorted(difference[:k])


    def findClosestElements_two_pointers(self, arr: List[int], k: int, x: int) -> List[int]:
        '''
        Time complexity: O(n - k) as we traverse the array once with two pointers until we have distance of k between 2 pointers.
        Space complexity: O(1) as no auxiliary space is used.
        '''
        if len(arr) == 0 or len(arr) < k or k < 0:
            return []

        low = 0
        high = len(arr) - 1
        result = []

        while high - low + 1 > k:
            if abs(arr[low] - x) > abs(arr[high] - x):
                low += 1
            else:
                high -= 1

        return arr[low:high + 1]

    def findClosestElements_binary_search(self, arr: List[int], k: int, x: int) -> List[int]:
        '''
        Time complexity: O(log n) as we perform the binary search to locate the starting point of sliding window.
        Space complexity: O(1) as no auxiliary space is used.
        '''
        if len(arr) == 0 or len(arr) < k:
            return []


        # initialize low and high
        low = 0
        high = len(arr) - k # we are making sure that we have k elements to the right of high if in case closest elements fall on the right

        # Start the binary search to find the sliding window
        while low < high:
            mid = low + int((high - low) / 2)

            # Now we are finding potential start and end points of the sliding window
            start = x - arr[mid]
            end   = arr[mid + k] - x

            if start > end:
                low += 1
            else:
                high = mid

        return arr[low:low+k]


# Driver code
solution = Solution()
inp, x, k = get_input()
print(f"Input list: {inp}")
print(f"Input k: {k}, x: {x}")
print(f"Approach 1: Using custom comparator: {k} closest elements to {x} are: {solution.findClosestElements_custom_comparator(inp, k, x)}")
print(f"Approach 2: Using lambda function: {k} closest elements to {x} are: {solution.findClosestElements_lambda_function(inp, k, x)}")
print(f"Approach 3: Using two pointers: {k} closest elements to {x} are: {solution.findClosestElements_two_pointers(inp, k, x)}")
print(f"Approach 4: Using binary search: {k} closest elements to {x} are: {solution.findClosestElements_binary_search(inp, k, x)}")
