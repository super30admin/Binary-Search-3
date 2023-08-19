# Time Complexity: O(logn) n:exponent
# Space Complexity: O(log n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = -n
        return self.power(x, n)

    def power(self, x, n):
        if x == 0:
            return 0
        if n == 0:
            return 1

        res = self.power(x, n // 2)
        if n % 2 == 0:
            return res * res
        else:
            return x * res * res
