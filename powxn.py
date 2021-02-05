# TIme: O(log n)
# Space: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# why Maximum Recursion Depth Error Occur?
# Key Use: int(n/2) instead of n//2
# Why ? 
# -1 // 2 = -1, so we would probably end up in ∞ loop but int(-1/2) is 0

class Solution:
    def myPow(self, x: float, n: int) -> float:
        #Base case
        if (n == 0 ):
            return 1

        #Logic
        temp = self.myPow(x, int(n/2))
        # if n is even 
        if n%2 == 0:
            return temp * temp
        # if n is -ve and odd
        elif n < 0:
            return temp * temp * (1/x)
        # if n is odd
        else:
            return temp * temp * x
