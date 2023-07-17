# Time Complexity : O(log(N-K)) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA
# Approach is to use modified binary search and find the k range and return the range of elements.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l=0
        h=len(arr)-k
        
        while(l<h):
            m=(l+h)//2
            if((x-arr[m])>(arr[m+k]-x)):
                l=m+1
            else:
                h=m
            
        return arr[l:l+k]