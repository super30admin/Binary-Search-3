"""
Runtime Complexity:
O(log n)- Here we call x^n in a recursive manner by breaking the main problem into subproblems. We divide the n by 2. So the recursion goes log n levels.
Space Complexity:
O(log n)- recursive stack space .
Yes, the code worked on leetcode.
Issues while coding- No
"""

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if (n == 0):
            return float(1)
        elif n<0:
            n*=-1   #make 'n' positive
            x = 1/x #make it a fraction
            
        result = self.myPow(x,n//2)
        if (n%2 == 0):
            return result * result
        else:    
            return result *result*x
            