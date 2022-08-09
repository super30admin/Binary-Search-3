#Time Complexity : O(Log(n))
#space Complexity : O(Log(n))
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            if x == 0:
                return float("inf")
            x = 1 / x
            n = -1 * n

        if n == 0:
            return 1
        if n == 1:
            return x

        curr = self.myPow(x, n // 2)

        if n % 2 == 0:
            return curr * curr
        else:
            return curr * curr * x