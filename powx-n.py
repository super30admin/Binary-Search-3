# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Base case
        if n == 0:
            return 1
        
        # Recursive case
        half = self.myPow(x, int(n / 2))
        
        if n % 2 == 0:
            return half * half
        else:
            if n<0:
                return half * half * 1/x
            else:
                return half*half*x
