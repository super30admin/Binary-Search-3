"""
The approach here is to calculate the power of x to n/2 and then multiply the resultant with itself,  
if n value is even, else multiply it with itself and also the x again if it's odd. since x^5 will be
 5/2 resulting in n = 2 so intially it will result to x^2 * x^2 = x ^ 4 . to make the correction we 
 need to do x^4 * x = x^5. hence we have the resultant.
"""

class Solution(object):
    def myPow(self, x, n):
        if n < 0:
            x = 1/x
            n = -n
        if n == 0:
            return 1
        half = self.myPow(x,n/2)
        if n % 2 == 0:
            half = half * half
        else:
            half = half * half * x
        return half


