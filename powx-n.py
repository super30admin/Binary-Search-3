#Time Complexity: O(logn)
#Space Complexity:O(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        result=1.0

        if n<0:
            n=n*(-1)
            x=1/x

        while n!=0:
            if n%2!=0:
                result=result*x
            x=x*x
            n=n//2
        return result

