# The myPow method computes x raised to the power n (x^n) using recursion.

# Base cases:
# - If x is 0, return 0.
# - If n is 0, return 1.

# Recursive logic:
# - Use helper(x * x, n // 2) to compute powers efficiently (divide-and-conquer).
# - Multiply by x if n is odd.

# Handle negative powers by computing the reciprocal.

# TC: O(log n) - Each recursive call halves n.
# SC: O(log n) - Space for the recursion stack.


class Solution:
    def myPow(self, x: float, n: int) -> float:
         def helper(x, n):
            if x == 0: return 0
            if n == 0: return 1

            res = helper(x * x, n //2)
            return x * res if n % 2 else res

         res = helper(x, abs(n))
         return res if n >= 0 else 1 / res