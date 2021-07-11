# TC: O(log(N-K)) :  
# SC: O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr)==0:
            return []
        
        low = 0
        high = len(arr)-1
        
        while(high-low+1>k):
            distL = x-arr[low]
            distH = arr[high]-x
            if distL>distH:
                low+=1
            else:
                high-=1
                
        result = arr[low:high+1]
        return result