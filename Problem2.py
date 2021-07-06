"""
// Time Complexity : o(n-k)
// Space Complexity : o(1), no auxillary data structure
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        l = 0 #two pointers
        h = len(arr) - 1
        
        while (h-l > k - 1): #finding the window of size k
            
            distL = abs(arr[l] - x) #for leftmost element
            distH = abs(arr[h] - x) #for rightmost element
            
            if distL > distH: #if difference is greater for left element, increment that pointer
                l += 1
            else:
                h -= 1 #else decrement right pointer
                
        return arr[l:h+1] #result will be low to high pointer