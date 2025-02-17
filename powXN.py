class Solution:
    def myPow(self, x: float, n: int) -> float:
        # T: O(log n), S: O(log n)
        def helper(x, n):
            # Base Case
            if x == 0:
                return 0
            if n == 0:
                return 1

            # Logic
            res = helper(x, n // 2)
            res *= res

            return x * res if n % 2 else res

        res = helper(x, abs(n))
        return res if n >= 0 else 1 / res
