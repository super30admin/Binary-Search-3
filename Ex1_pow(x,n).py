# ----------------------------------------------------
# Intuition:
# We are given a base `x` and an integer exponent `n`, and need to compute `x^n`.
#
# A brute-force approach would multiply `x` by itself |n| times.
# A better approach uses recursion and divides the problem into halves (Exponentiation by Squaring),
# where we repeatedly square the base and halve the exponent to reduce computation.
# The most optimal solution is the iterative version of Exponentiation by Squaring, which avoids recursion overhead.
# It handles both positive and negative exponents in O(log |n|) time.
# ----------------------------------------------------


# ----------------------------------------------------
# Time Complexity: O(log |n|)
# - Each step halves the exponent
#
# Space Complexity: O(1)
# - No recursion; just loop and constant space
# ----------------------------------------------------

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0

        if n < 0:
            x = 1 / x
            n = -n

        result = 1.0
        while n:
            if n % 2 == 1:
                result *= x
            x *= x
            n //= 2

        return result

# ------------------------------------------------------
# Recursive Exponentiation by Squaring
#
# Time Complexity: O(log |n|)
# - Recursively halves the exponent
#
# Space Complexity: O(log |n|)
# - Due to recursive call stack
#
# Intuition:
# - x^n = (x^(n//2))^2     if n is even
# - x^n = x * (x^(n//2))^2 if n is odd
# - Handle negative n by computing 1 / x^|n|
#
#     class Solution:
#         def myPow(self, x: float, n: int) -> float:
#             if n == 0:
#                 return 1.0
#
#             if n < 0:
#                 return 1 / self.myPow(x, -n)
#
#             half = self.myPow(x, n // 2)
#             if n % 2 == 0:
#                 return half * half
#             else:
#                 return half * half * x

# ------------------------------------------------------
# Brute Force Approach (Naive Multiplication)
#
# Time Complexity: O(|n|)
# - Loop runs |n| times
#
# Space Complexity: O(1)
# - No extra space used
#
# Intuition:
# - Multiply x by itself |n| times using a loop
# - Handle negative n by computing reciprocal
#
#     class Solution:
#         def myPow(self, x: float, n: int) -> float:
#             if n == 0:
#                 return 1.0
#
#             exp = abs(n)
#             result = 1.0
#             for _ in range(exp):
#                 result *= x
#
#             return 1.0 / result if n < 0 else result



if __name__ == "__main__":
    sol = Solution()

    # Test Case 1
    x = 2.0
    n = 10
    print(f"myPow({x}, {n}) = {sol.myPow(x, n)}")  # Output: 1024.0

    # Test Case 2
    x = 2.1
    n = 3
    print(f"myPow({x}, {n}) = {sol.myPow(x, n)}")  # Output: 9.261

    # Test Case 3
    x = 2.0
    n = -2
    print(f"myPow({x}, {n}) = {sol.myPow(x, n)}")  # Output: 0.25

    # Test Case 4
    x = 1.0
    n = 0
    print(f"myPow({x}, {n}) = {sol.myPow(x, n)}")  # Output: 1.0

    # Test Case 5
    x = 0.5
    n = 4
    print(f"myPow({x}, {n}) = {sol.myPow(x, n)}")  # Output: 0.0625

    # Test Case 6
    x = 3.0
    n = 1
    print(f"myPow({x}, {n}) = {sol.myPow(x, n)}")  # Output: 3.0

