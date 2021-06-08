## Problem1 
# Pow(x,n) (https://leetcode.com/problems/powx-n/)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        # Negative Power
        elif n < 0:
            return 1 / self.myPow(x, -n)
        # Even Power
        elif n % 2 == 0:
            return self.myPow(x * x, n / 2)
        # Odd Power
        else:
            return x * self.myPow(x, n - 1)
    #Approach: Recursion 
    #Time Complexity: O(n)
    #Space Complexity: O(1)
