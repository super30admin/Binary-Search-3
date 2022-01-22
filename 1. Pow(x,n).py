class Solution:
    # Time Complexity - O(logn)
    # Space Complexity - O(logn)
    def fastpower(self, x, n):
        if n == 0:
            return 1.0
        A = self.fastpower(x, n // 2)
        if n % 2 == 0:
            return A * A
        else:
            return A * A * x

    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = -n
        return self.fastpower(x, n)