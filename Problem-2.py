# Time Complexity : O(log(N - k) + k), N = length of arr
# Space Complexity : O(k), storing k closest elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Use binary search to find the left bound of the k closest elements.
# Compare distances between arr[mid] and arr[mid + k] to shrink search space.
# Finally, return arr[left:left + k] as the k closest elements.

from typing import List

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left, right = 0, len(arr) - k
        while left < right:
            mid = (left + right) // 2
            # If x is closer to arr[mid + k] than arr[mid], move window right
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left + k]