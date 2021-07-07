"""
Time : O(log (length - k))
Space : O(1)
Leetcode Compiled : yes
Problems and Explanation: The window of mid..mid+k, could be used as a sliding window.
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        # Make a window of size k
        left = 0
        right = len(arr) - k
        
        while left < right:
            
            mid = left + (right - left) // 2
            
            # If mid + k is closer to x than mid, move to the right 
            if(arr[mid + k] - x < x - arr[mid]):
                left = mid + 1
            
            # If our mid is closer to x than mid + k, then the left part of our window
            # needs to be moved left.
            else:
                right = mid
                
        return arr[left:left+k]