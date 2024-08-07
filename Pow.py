#// Time Complexity : O(log n) 
# // Space Complexity : Recursive stack 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            return 1 / self.myPow(x, -1 * n)
        
        if n % 2 == 0:
            return self.myPow(x * x, n // 2)
        else:
            return x * self.myPow(x*x, (n-1) // 2)

# Approach:
# The problem can be solved using a recursive approach. The idea is to divide the problem into smaller sub
# problems. If the power is 0, return 1. If the power is negative, return
# 1 divided by the result of the function called with the absolute value of the power. If the power
# is even, return the result of the function called with half the power and the square of the base
# If the power is odd, return the base times the result of the function called with half the power
# and the square of the base minus one. 

