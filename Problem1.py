# https://leetcode.com/problems/powx-n/description/

# Recursive solution
# TC: log(n)
# SC: log(n)

class Solution:
    def myPow(self, x: float, n: int) -> float:

        if n == 0:
            return 1

        if n < 0:
            n = -n
            x = 1/x
        
        res = self.myPow(x,n//2)

        if n % 2 == 0:
            return res * res
        else:
            return res * res * x
        
# Iterative solution
# TC: log(n)
# SC: O(1)

class Solution:
    def myPow(self, x: float, n: int) -> float:

        res = 1.0

        if n < 0:
            x = (1/x)
            n = -n

        while n != 0:
            if n % 2 != 0:
                res = res * x
            n = n//2
            x = x*x

        return res

