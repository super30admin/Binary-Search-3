"""
TC: O(log n)
SP = O(log n) number of recursive calls
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        res = self.myPow(x, int(n/2))
        if n%2 ==0:
            return res*res
        else:
            if n <0:
                return res*res/x
            else:
                return res*res*x