# Time Complexity : O(log n-k)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from math import floor
from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        # setting the pointers
        low = 0
        high = len(arr) - k

        # binary search approach
        while low < high:
            mid = floor((low + high) / 2)

            # finding the distances of the pointers
            dist_low = x - arr[mid]
            dist_high = arr[mid + k] - x

            if dist_low > dist_high:
                low = mid+1
            else:
                high = mid

        result = []

        for i in range(low, low + k):
            result.append(arr[i])

        return result
