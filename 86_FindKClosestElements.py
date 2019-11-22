'''
Accepted on leetcode(658)
time - O(max(logn, k)), space - O(1)
'''


class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        # Initialize variables
        result = []
        NOE = k
        target = x

        low = 0
        high = len(arr) - NOE - 1  # We do this to avoid going out of bound of array.

        # 1. Find the starting point using binary search 3. Use low as starting point.

        while low <= high:

            mid = low + (high - low) // 2  # Toavoid integer overflow in java
            # the condition to move the high and low pointer and recalculate the mid each time to find the start index.
            if abs(arr[mid] - target) > abs(arr[mid + NOE] - target):
                low = mid + 1
            else:
                high = mid - 1

        # 2. Add elements to the list with starting point.
        for i in range(NOE):
            result.append(arr[low + i])
        return result