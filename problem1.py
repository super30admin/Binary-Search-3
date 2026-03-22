# problem 1 
# https://leetcode.com/problems/powx-n/description/


class Solution:
    def myPow(self, x: float, n: int) -> float:
        result = 1.0 
        # if its negative we convert it
        if n < 0:
            x = 1/x
            n = n * -1
        while n != 0:
            if n % 2 != 0:
                result = result * x
            x = x * x 
            n = n // 2
        return result