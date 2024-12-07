# Time:O(logn)
# Space:O(h) stack
# Leetcode:Yes
# Issues:No
# Recursion
class Solution:
    def myPow(self, x: float, n: int) -> float:        
        if n==0:            # raised to 0 = 1
            return 1
        if n < 0:           # to find n//2 we need to know if n is negative
            x = 1/x         
            n = -n

        result = self.myPow(x,n//2)

        if n % 2 == 0:
            return result * result
        else:
            return result * result * x
        
# Time:O(logn)
# Space:O(1)
# Leetcode:Yes
# Issues:result is 1.0 not 1
# while
class Solution:
    def myPow(self, x: float, n: int) -> float:        
        if n < 0:           
            x = 1/x         
            n = -n
            
        result = 1.0                # float

        while n != 0:
            if n%2 != 0:
                result = result * x
            x = x*x
            n = n//2
            
        return result
