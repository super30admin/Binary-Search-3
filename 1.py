'''
Binary-Search-3

Problem1

Pow(x,n) (https://leetcode.com/problems/powx-n/)
'''

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0

        if n < 0:
            n = n * -1
            x = 1/x

        result = self.myPow(x, n//2)

        if n%2 == 0:
            return result * result

        else:
            return result * result * x        
