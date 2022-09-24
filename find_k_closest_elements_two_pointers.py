# Time Complexity : O(n - k) + O(k) where n length of the array and k is number closest elements to findout
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - 1
        
        while high - low + 1 > k:
            if x - arr[low] < arr[high] - x:
                high -= 1
            elif x - arr[low] > arr[high] - x:
                low += 1
            else:
                high -= 1
                
            
        return arr[low: high + 1]