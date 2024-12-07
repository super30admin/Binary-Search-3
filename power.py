# TC: O(logn)
# SC: O(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        res = 1
        m = n
        flag = False
        if m < 0:
            flag = True
            m = - m
        while m > 0:
            if m % 2 != 0:
                res *= x
            x = x * x
            m = m // 2
        
        if flag:
            return 1/res
        return res
