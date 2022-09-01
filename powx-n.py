# Time: O(logn)
# Space: O(logn)
# Can do iterative for O(1) space
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Base
        if n ==0:
            return 1.00
        #Logic
        result = self.myPow(x,n//2)
        if n%2 == 0:
            return result*result
        else:
            if n>0:
                return result*result*x
            else:
                return result*result*1/x