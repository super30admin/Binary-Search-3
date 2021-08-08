# Time Complexity : O(logn)
# Space Complexity : O(logn)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Base
        if n == 0:
            return 1
        # Logic
        result = self.myPow(x, int(n / 2))
        # Even:
        if n % 2 == 0:
            return result * result
        if n < 0:
            return result * result * 1 / x
        else:
            return result * result * x