"""
// Time Complexity : O(logn + k) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Idea is to find the start position from where we can iterate k elements in the array
Binary search helps us find the start position by reducing the search space
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #Binary search based approach
        size = len(arr)
        l = 0
        h = size - k
        
        while l < h:
            mid = (l + h) // 2
            
            #fixing the left bound using the mid
            L_B = abs(x - arr[mid])
            
            #fixing the highest possible bound having the knowledge of mid and k
            R_B = abs(x - arr[mid+k])
            if L_B > R_B:
                l = mid+1
            else:
                h = mid
        
        return arr[l:k+l]