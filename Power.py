# Time Complexity: O(log n) where n is the exponent.
# Space Complexity: O(1).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def myPow(self, x: float, n: int) -> float:
        res = self.helper(x, abs(n))
        if n >= 0:
            return float(res) 
        else:
            return 1 / res

    def helper(self, base, exp):
        
        if exp == 0: 
            return 1
        if exp % 2 == 0:
            return self.helper(base * base, exp // 2)
        else:
            return self.helper(base * base, exp // 2) * base