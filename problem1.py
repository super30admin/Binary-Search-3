# Space Complexity : O(1)
# Time Complexity: O(logn)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        re = 1.0
        if n < 0: 
            x = 1/x
            n*=-1
            
        while n != 0: 

            if n%2 == 1: 
                re = re * x
            
            n = n//2
            x = x*x
            
        return re
                
