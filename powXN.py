"""
Repeatedly square x and reducing n by half
Multiply the result with current x, if n is odd
For negative n, find pow(1/x, -n)
"""
"""
Time Complexity: O(log n) — due to repeated halving
Space Complexity: O(log n) for recursive O(1) for iterative
"""


class powXN:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = -n
        
        res = 1
        while n:
            if n % 2 == 1:
                res *= x
            x *= x
            n //= 2
        return res

obj = powXN()
print(obj.myPow(2.0, 10))
print(obj.myPow(2.1, 3))
print(obj.myPow(2.0, -2))

"""
Recursive
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            return 1 / self.myPow(x, -n)
        
        half = self.myPow(x, n // 2)
        return half * half if n % 2 == 0 else half * half * x
"""
