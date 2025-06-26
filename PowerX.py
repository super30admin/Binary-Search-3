# Time Complexity: O(log n)
# Space Complexity: O(log n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Base
        if n==0:
            return 1.0
        # logic
        if n<0:
            x=1/x
            n=-n
        re = self.myPow(x,n//2)
        if n%2==0:
            return re * re
        else:
            return re * re * x