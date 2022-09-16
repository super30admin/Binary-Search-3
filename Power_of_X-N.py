'''
Time Complexity - O(logn)
Space Complexity - O(logn)
'''


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.00
        if n < 0:
            n = -n
            x = (1/x)
        res = self.myPow(x, n//2)
        if n % 2 == 0:
            return res*res
        elif n > 0:
            return res*res*x
        else:
            return res*res*(1/x)
