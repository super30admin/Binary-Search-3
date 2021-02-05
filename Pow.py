# TC: O(logn)
# SC: O(logn)

# Base: 
# 1)if power = 0: return 1  
# 2) n is -ve, we return reciprocal of recursive fn with positive of n [2^-7 = 1/2^7]
# Logic:  
# if n is even: return x^(half of prev) * x^(half of prev)
# if n is odd: return x^(half of prev) * x^(half of prev) * x

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0: return 1
        if n < 0: 
            return 1/self.myPow(x, -n)
        
        # logic
        temp = self.myPow(x, n//2)
        if n%2 == 0:
            return temp*temp
        else:
            if n < 0:
                return temp*temp*(1//x)
            else:
                return temp*temp*x