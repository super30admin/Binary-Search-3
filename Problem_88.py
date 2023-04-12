# TC : O(log N)
# SC : O(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n = -n
        res = 1
        while n != 0:
            if n % 2 != 0:
                res = res * x
            x = x * x
            n = int(n/2)
        return res