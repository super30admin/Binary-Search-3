# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use binary exponentiation 
# If n is negative, convert it to positive and invert x.
# Repeatedly square x and reduce n by half.
# If n is odd, multiply result with current x.
# Continue until n becomes 0, giving final result.


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            n = -n
            x = 1/x
        res = 1.0
        while n != 0:
            if n % 2 == 1:
                res *= x 
            x *= x
            n = n // 2
        
        return res
