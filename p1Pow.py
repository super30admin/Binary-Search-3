"""
time: O(N)
space: O(1)
"""



class Solution:
    def myPow(self, x: float, n: int) -> float:
        b = abs(n) -1
        exp = x
        if (n < 0): exp = 1/x

        if (n is 0): return 1
 
        for i in range(b): 
            if (n < 0):
                exp = exp * 1/x
            else:exp = exp * x
        return exp

