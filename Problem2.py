"""
    Student : Shahreen Shahjahan Psyche
    Time    : O(N) [Linear search]
    Space   : O(1) [No Auxiliary Space Has Been Used]
              
    Pased Test Cases : Yes
    
"""

class Solution:
    
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        # the two pointer solution 
        
        # edge case
        if not arr:
            return []
        
        low = 0
        high = len(arr) - 1
        flag = True
        while(high - low + 1 > k):
            distL = abs(x - arr[low])
            distR = abs(x - arr[high])
            
            # if the distance from the low pointer is higher than the high pointer, then we increase our low otherwise decrease
            # high
            if distL > distR:
                low += 1
            else:
                high -= 1
        
        return arr[low:high+1]
            
            
        
        
