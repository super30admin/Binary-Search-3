# recursive
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Handle negative exponents upfront to fix Python's modulo behavior
        if n < 0:
            x = 1 / x
            n = -n
            
        if n == 0: return 1

        # Use integer division (//) instead of float division (/)
        res = self.myPow(x, n // 2)

        if n % 2 == 0:
            return res * res
        else:
            return res * res * x

# iterative
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n = -n  # Fix 1: Make n positive so the loop terminates
        
        result = 1
        while n != 0:
            if n % 2 != 0:
                result = result * x
            x = x * x
            n = n // 2  # Fix 2: Use integer division
        
        return result