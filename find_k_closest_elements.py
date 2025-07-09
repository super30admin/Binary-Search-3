# Time Complexity : O(log(n - k)), where n is the length of the array
# Space Complexity : O(1), since I used a sliding window on the input array without extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used a binary search approach to find the left boundary of a sliding window of size k.
# The goal was to find the window such that the k elements inside it are closest to x.
# I compared the distances between x and the edges of the window to decide the direction of the binary search.

from typing import List

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr) - k

        while left < right:
            mid = (left + right) // 2

            # I compared which side is farther from x and eliminated it
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid

        # After the loop, left is the start index of the closest window
        return arr[left:left + k]
