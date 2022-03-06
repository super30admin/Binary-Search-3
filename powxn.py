"""
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

"""

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0:
            return 1
        
        if n > 0:
            a = n//2
        else:
            a = -(-n//2)
            
        result = self.myPow(x, a)
        
        if n%2 == 0:
            return result*result
        else:
            if n > 0:
                return result*result*x
            else:
                return result*result*(1/x)
                
        
        
        





