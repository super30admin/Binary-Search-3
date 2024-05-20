## Problem1 
# Pow(x,n) (https://leetcode.com/problems/powx-n/)

# Approach
# Recursively call the myPow function with n//2. This will half the numbers each time. if n == 0, return 1. if n == 1, return x and if n == -1, return 1/x
# if n < 0, set x = 1/x and pow n to -n. if n is even, res = res * res and if n id odd, res = res * res * x
# return res

# Time Complexity : O(logn)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Recursive Approach
        # base
        print(n)
        if(n == 0): return 1
        if(n == 1): return x
        if(n == -1): return 1/x

        # logic
        if (n<0): 
            x = 1/x
            n = -n

        res = self.myPow(x,n//2)
        

        if (n%2 != 0):
            res = res * res * x
        else:
            res = res * res

        return res