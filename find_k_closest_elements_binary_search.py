# Time Complexity : O(log(n-k)) + O(k) where n length of the array and k is number closest elements to findout
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k
        
        while low < high:
            mid = low + (high - low) // 2
            diffL = x - arr[mid]
            diffH = arr[mid + k] - x
            
            if diffL > diffH:
                low = mid + 1
            else:
                high = mid
            
        return arr[low: low + k]