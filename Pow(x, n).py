# Time Complexity : O(log n)
# Space Complexity : O(log n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def fastPow(x: float, n: int) -> float:
            if n == 0:
                return 1.0
            if n == 1:
                return x
            if n < 0:
                x = 1 / x
                n = -n
            half = fastPow(x, n // 2)
            if n % 2 == 0:
                return half * half
            else:
                return half * half * x
        
        return fastPow(x, n)