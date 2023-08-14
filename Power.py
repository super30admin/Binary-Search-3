#Time complexity: O(log n) // Since we are halving in every recursion call
#Space complexity: O(h)//recursion depth

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        if n<0:
            x=1/x
            n=-n
        half_pow=self.myPow(x,n//2)
        if n%2==0:
            return half_pow * half_pow
        else:
            return half_pow * half_pow * x

