# Time complexity : O(log n)
# Space complexity : O(log n)
# Leetcode : Solved and submitted
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        # if n is 0, then we simpley return 1.00
        if n == 0:
            return 1.00
        # if in recursive call, we have a negative n, then we multiply it with -1, to make it positive.
        # For negative exponent, the lowest it'll go to is -1, which goes on infinite loop, which is why this is required
        # also, for negative numbers we inverse the value of x to 1/x
        if n < 0:
            n = n*(-1)
            x = (1/x)
        
        # logic
        # recursively call the x by dividing the value of n
        res = self.myPow(x, n//2)
        # if n is even, then we mulitply the res twice each time
        if n%2 == 0:
            return res*res
         # if odd, then multiply number twice and value of x once
        elif n > 0:
            return res*res*x
        else:
          # else if n is negative, then multiply number with 1/x
            return res*res*(1/x)
