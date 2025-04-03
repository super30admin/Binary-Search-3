#Time Complexity: O(logn)
# Space complexity: O(logn)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n < 1:
            x = 1/x
            n = -n
        y = self.myPow(x, n//2)
        if n % 2 == 0:
            return y * y 
        else:
            return y*y*x
