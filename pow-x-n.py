#if the power is even, the number can be divide as x^(n/2) * (x^(n/2)) * x -- > 2^4 = 2^2*2^2
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        elif n < 0:
            return 1 / self.myPow(x, -n)
        
        v = self.myPow(x, n//2)
        
        if n % 2 == 0:
            return v*v
        else:
            return v*v*x