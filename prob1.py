# Time Complexity :O(logn)
# Space Complexity :O(n)
# Leet Code: Yes

class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x, n):
            # base case
            if n == 0:
                return 1

            # logic
            if n < 0:
                return helper(1 / x, -n)
            if n % 2 == 0:
                return helper(x * x, n // 2)
            else:
                return x * helper(x * x, n // 2)

        return helper(x, n)