# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low, high = 0, len(arr) - k

        while low < high:
            mid = low + (high - low)//2

            abs_mid = x - arr[mid]
            abs_mid_plus_k = arr[mid+k] - x

            if abs_mid <= abs_mid_plus_k:
                high = mid
            else:
                low = mid + 1
        
        return arr[low:low+k]