#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def myPow(self, x: float, n: int) -> float:
        m = abs(n)
        ans = 1.0
        while m:
            #if exponent is odd
            if m%2==1:
                ans *= x
            x *= x
            m //= 2
        return ans if n >= 0 else 1 / ans
