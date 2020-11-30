# Time:- O(logn) We are diving the power by half every time
# Space:- O(logn) The recursion stack for the logn recursive calls
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def rec(x,pows):
            if pows==0:
                return 1
            half=rec(x,pows//2)
            if pows%2==0:
                return half*half
            return half*half*x
        if n<0:
            x=1/x
            n=-n
        return rec(x,n)
        