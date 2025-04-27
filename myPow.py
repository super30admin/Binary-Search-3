# Approach:
# - Handle negative powers by taking reciprocal at the end: x^-n = 1 / x^n.
# - Use recursion and divide the power by 2 each time (Exponentiation by Squaring).
# - If n is even, result is res * res; if odd, multiply one extra x.
#
# Time Complexity: O(log n), because we divide n by 2 at each step.
# Space Complexity: O(log n), because of recursive call stack depth.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # 1. n is negative: 2^-2 = 1/2^2
        # 2. n is positive
        # 3. x is 0

        # Optimization: 2^5 = 2^2 * 2^2 * 2 if n is odd, else 2^4 = 2^2 * 2^2

        def helper(x, n):
            if x == 0:
                return 0
            if n == 0:
                return 1

            res = helper(x, n // 2)
            res = res * res

            return x * res if n % 2 else res
        
        res = helper(x, abs(n))
        return res if n >= 0 else 1 / res
