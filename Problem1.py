# Time Complexity : O(n)
# Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
#1. The function uses exponentiation by squaring to compute the power of a number efficiently.
#2. It handles both positive and negative powers by adjusting the result accordingly.
#3. The loop iteratively squares the base and reduces the exponent, multiplying the result when the exponent is odd.
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        #a result variable to keep the result in double precision
        res=1.00000
        #if n is negative, we will take the reciprocal of the result
        neg=n<0
        #if n is negative, we will convert it to positive for easier calculations
        n=abs(n)
        #while n is greater than 0, we will keep squaring x
        while n>0:
            #if n is odd, we multiply the result with x
            if n%2==1:
                res*=x
            #square x for the next iteration
            x*=x
            #reduce n by half to reduce the computation space
            n/=2
        #if n was negative, we return the reciprocal of the result
        return 1/res if neg else res