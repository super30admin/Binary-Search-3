# Time Complexity : O(logn) where n are the number of head nodes.
# Space Complexity : O(logn) where k are the total number of nodes in total.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base 
        if n < 0 :  # Negative
            if x == 0:
                return float('inf')   # 1/(0) ^ n 
            x = 1 / x 
            n = abs(n)
        
        if n == 0:
            return 1 
        
        if n == 1 :
            return x 
        
        # logic 
        res = self.myPow(x, n // 2)   # O(logn)
        # 1) even 
        if n % 2 == 0: 
            return res * res 
        else:
            return res * res * x 
        return res
    