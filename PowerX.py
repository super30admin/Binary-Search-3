# Problem1 Pow(x,n) (https://leetcode.com/problems/powx-n/)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n = -1 * n
        re = 1.0
        while n != 0:
            if n % 2 != 0:
                re = re * x
            x = x * x
            n = n // 2
        return re

# Time complexity O(logn)
# Space complexity O(1)