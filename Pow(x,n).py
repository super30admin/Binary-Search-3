"""
TC: O(log n)
SC: O(log n)
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        ans = self.find(x, abs(n))
        return 1/ ans if n < 0 else ans

    def find(self, x, n):
        if n == 0:
            return 1
        if x == 0:
            return 0
        res = self.find(x, n//2)
        return res * res if n % 2 == 0 else res * res * x