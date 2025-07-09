# Time Complexity : O(log n), because I reduced the power by half in each recursive call
# Space Complexity : O(log n), due to recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used a recursive divide-and-conquer approach (fast exponentiation).
# If n is negative, I converted the problem to computing the positive power of the reciprocal.
# At each step, I squared the result of half the exponent, and multiplied by x again if n was odd.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0

        if n < 0:
            x = 1 / x
            n = -n

        half = self.myPow(x, n // 2)

        if n % 2 == 0:
            return half * half
        else:
            return half * half * x
