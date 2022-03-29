# // Time Complexity : O(log (n) + k)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        l, r = 0, len(arr)-k 
        
        while(l<r):
            m = (l+r) // 2
            
            # Expand the window to the side which is closer to x
            if x - arr[m] > arr[m+k] - x:
                l = m+1
                
            else:
                r = m
                
        return arr[l:l+k]