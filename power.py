"""
Time : O(logN))
Space : O(1)
Leetcode Compiled : yes
Problems and Explanation: not exactly binary search.
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        #@ Base case
        if not n:
            return 1
        # Negative numbers
        if n < 0:
            return 1 / self.myPow(x, -n)
        # If our n is even, then subtract 1
        if n % 2:
            return x * self.myPow(x, n-1)
        else:
            return self.myPow(x*x, n/2)
        