# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : If the exponent is negative, we invert x and make n positive.
# We loop while n is non-zero, multiplying result when n is odd.
# Each step squares x and halves n to reduce work logarithmically.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = -1 * n

        res = 1.0

        while n != 0:
            if n % 2 != 0:
                res = res * x

            n = n // 2
            x = x * x
        
        return res
        