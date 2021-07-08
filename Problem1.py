# Time Complexity : O(logn)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n == 1:
            return x
        if n < 0:
            return 1 / (self.myPow(x,abs(n)))
        a = self.myPow(x,n//2)
        if n % 2 == 0:
            return a*a
        else:
            return a*a*x
        