"""
Time Complexity : O(logn) where n is the power number given
Space Complexity : O(logn) where n is the power number given
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Check whether the value of n is negative or positive
        if n < 0:
            return 1 / self.pow(x, -n)
        else:
            return self.pow(x,n)
    def pow(self, x, n):
        # Base
        if n == 0: return 1
        # Logic
        y = self.myPow(x, n//2)
        if n % 2 == 0:
            return y * y
        else:
            return y * y * x
            