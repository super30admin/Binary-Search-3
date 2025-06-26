"""
TC -> O(log n)
SC -> O(1), no extra space used except call stack space.
Logic
Use X^n =X^n/2 . X^n/2 logic when n is even.
Use X^n = X. X^n/2 . X^n/2 logic when n is odd
Use recursion.

"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def func(base, exp):
            if exp == 0:
                return 1
            if exp == 1:
                return base
            factors = func(base, exp//2)
            extra = 1
            if exp%2 == 1:
                extra = base
            return factors*factors*extra
        if x == 0:
            return 0
        res = func(x, abs(n))
        return res if n>0 else 1/res
