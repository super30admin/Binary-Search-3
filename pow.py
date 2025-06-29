# // Time Complexity : O(logn)
# // Space Complexity : O(logn)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0: return 1

        # logic
        # handle -ve case
        if n < 0:
            x = 1/x
            n = abs(n) # can revert to abs value as it is 

        # recursive step
        re = self.myPow(x, n//2)
        
        # factoring for odd/even powers
        if n % 2 == 0: # if power is even
            return re * re
        else: # if power is odd
            return re * re * x