# Time Complexity : O(log n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I use the equation where result is pow(x^n/2, x^n/2) recursively and multiply by x if n/2 is odd

class Solution:

    def myPow(self, x: float, n: int) -> float:
        if n <  0: n, x = -n, 1/x
        if n == 0: return 1
        if n == 1:
            return x 
        if n % 2 != 0:
            res = self.myPow(x, n // 2) 
            return  res * res * x
        else:
            res = self.myPow(x, n // 2) 
            return res * res