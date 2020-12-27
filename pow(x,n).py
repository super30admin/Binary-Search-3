# time=O(logn)
# space-O(1) or recursion stack?
# des- divide and iterate through itself

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            x = 1 / x
            n = -n
        temp = self.myPow(x, n // 2)
        if n % 2 == 0:
            return temp * temp
        else:
            return temp * temp * x
