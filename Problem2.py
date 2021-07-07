# Time Complexity : O(nlogk) where n are the number of head nodes.
# Space Complexity : O(k) where k are the total number of nodes in total.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def findClosestElements(self, arr, k, x):
        low = 0 
        high = len(arr) - 1 
        
        while low <= high:
            if len(arr[low:high+1]) == k:
                return arr[low:high+1]
            
            elif abs(x - arr[low]) <= abs(x - arr[high]):
                high -= 1 
            
            else:
                low += 1 
        return -1 
    
