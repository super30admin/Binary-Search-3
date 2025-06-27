"""
Problem: Power x^n
approach: solve the problem iteratively instead of recursively. What we were solving top down can be solved
bottom up.
t.c. => O(logn)
s.c. => O(1)
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        res = 1
        
        tempX = 1
        
        if n < 0:
            x = 1/x
            n = -n
        i = n

        while i > 0:
            if n == i:
                tempX = x
            else:
                tempX = (tempX * tempX)

            if i > 1 and  i % 2 != 0:
                res *= tempX
            i = i//2
        return res * tempX