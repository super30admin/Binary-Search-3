# Pow(x,n) (https://leetcode.com/problems/powx-n/)

# Time Complexity : O(log n)
# Space Complexity :o (log n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0

        if n < 0:
            x = 1/x
            n = -n

        re = self.myPow(x,n//2)

        if n%2 != 0:
            return re * (re * x)
        else:
            return re * re   


# TC and SC: log(n)


########### Iterative Approach ###########

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n *= -1
        re = 1
        while n!=0:
            if n%2 != 0:
                re *= x
            
            x*=x
            n = n//2
        return re


# TC: log(n)
# SC: O(1)