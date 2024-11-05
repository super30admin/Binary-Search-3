# 50. Pow(x, n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        N = n
        if n < 0:
            n = -n

        result = 1
        while n != 0:
            if n%2 != 0:
                result = result * x

            n = n // 2
            x = x * x

        if N > 0:
            return result
        return 1 / result
        