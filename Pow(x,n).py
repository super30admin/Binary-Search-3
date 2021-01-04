"""
Apporach:

For x = 2, n = 6
2^6 = 2^3 * 2^3
2^3 = 2^1 * 2^1 * 2
2^1 = 2^0 * 2^0
2^0 = 1 

So what we are doing is recursing over way to the base above. So the general formula would be like this

n = even; x^n = x^(n/2) * x^(n/2)
n = odd and +ve; x^n = x^(n/2) * x^(n/2) * x
n = odd and -ve; x^n = x^(n/2) * x^(n/2) * 1/x

Time complexity: O(logn)
Space complexity: O(logn)
"""

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0:
            return 1
        
        # logic
        temp = self.myPow(x, int(n/2))
        if n % 2 == 0:
            return temp * temp
        else:
            if n < 0:
                return temp * temp * 1/x
               
            return temp * temp * x
        
        
        
        