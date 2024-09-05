# Time complexity = O(logn)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n = abs(n)

        def recurse(x,n):
            if n == 0:
                return 1.0
            re = recurse(x,n//2)
            if n%2 == 0:
                return re * re
            else: 
                return re * re * x

        return recurse(x,n)
        

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n *= -1

        res = 1.0
        while n:
            if n%2 == 1:
                res *= x
                n -= 1
            x *= x
            n //= 2
        return res
