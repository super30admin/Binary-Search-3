# Time Complexity: O(log n)
# Space Complexity: O(1)

# Solution:

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0:
            return 1

        # logic
        y = self.myPow(x, int(n / 2))

        if n % 2 == 0:
            return y * y
        else:
            if n < 0:
                return (y * y) * (1 / x)
            else:
                return (y * y) * x

