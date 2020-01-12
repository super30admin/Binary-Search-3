# Runs on Leetcode
      # Runtime - O(logn) where n is power integer
      # Memory - O(n) considering the recursive stack

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
        return self.helper(x,abs(n))
    
    def helper(self,x,n):
        if n == 0:
            return 1
        if n == 1:
            return x
        
        res = self.helper(x,n//2)
        res *= res
        if n%2 == 1:
            res*=x
        return res
