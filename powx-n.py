# We use recursive exponentiation by squaring, reducing n by half at each step (O(log n)). 
# If n is negative, we take the reciprocal (1/xⁿ), ensuring efficient computation. 
# Time: O(log n), since we divide n by 2 at each step.
# Space: O(log n), due to recursion stack.
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0 :
            return 1/self.myPow(x, -n)
        if n % 2 == 0:
            half = self.myPow(x, n//2)
            return half * half
        if n % 2 > 0:
            return x * self.myPow(x, n-1)
        