# Time Complexity : O(log n) where N is power to the x
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        calc = self.myPow(x, int(n/2))
        
        if n % 2 == 0:
            return calc * calc
        else:
            if n < 0:
                return calc * calc * (1/x)
            
            return calc * calc * x