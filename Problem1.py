# TC = O(log n)  | SC = O(log n)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if (n < 0):
            if (x == 0):
                return float('inf')
            x = 1 / x
            n = -1 * n

        #   base cases of when n is 0 and n is 1
        if (n == 0):
            return 1
        if (n == 1):
            return x

        val = self.myPow(x, int(n / 2))

        if (n % 2 == 0):
            return val * val
        else:
            return x * val * val
