#TC - O(logn)
#SC - O(logn)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def f(x,n):
            if x==0:
                return 0
            if n==0:
                return 1
            res = f(x,n//2)
            res*=res
            return x*res if n%2 else res
        res = f(x,abs(n))
        return res if n>=0 else 1/res