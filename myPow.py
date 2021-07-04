"""
Time Complexity : O(log n)
Space Complexity : O(1) [O(log n) - stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base case
        if n == 0:
            return 1
              
        # logic
        temp = self.myPow(x, int(n/2))
           
        if n % 2 == 0:
            return temp * temp
        else:
            if n > 0:
                return temp * temp * x
            if n < 0:
                return temp * temp * (1/x)
            
s = Solution()
print(s.myPow(2.03000, -4))