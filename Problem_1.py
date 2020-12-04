"""
Time Complexity : O(n/2) 
Space Complexity : O(n/2)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
We recursively divide n by 2 until it reches 0 and then keep on multiplying the result 
with itself and return
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            x = 1/x
            n = -n
        res = self.myPow(x, n//2)
        if n % 2 == 0:
            return res*res
        else:
            return res*res*x
