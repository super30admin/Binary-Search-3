# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We solve this problem by using binary search. We look for the start of the window by finding the 
difference between number with high and low. The start of the window is moved to the left if the 
difference between the number at mid and x is greater than the difference between the number at 
mid + k and x. We return the window from low to low + k.
"""

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if arr == None or len(arr) == 0: return []

        low = 0
        high = len(arr) - k

        while low < high:
            mid = (low + high) // 2
            dist_low = x - arr[mid]
            dist_high = arr[mid + k] - x

            if dist_low > dist_high:
                low = mid + 1
            else:
                high = mid

        return arr[low: low + k]