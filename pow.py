# TC: log(N)
# SC: O(1)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        # MOD = (x / abs(x)) * 10e4 # if x > 0 else -10e4
        # base
        if x == 0 or x == 1:
            return x
        if n==0:
            return 1
        if n < 0:
            return self.myPow(1./x, abs(n))
        if n == 1:
            return x
        base = self.myPow(x, n//2)
        if n%2 == 0:
            return  base * base
        else:
            return x * base * base