class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n ==0:
            return 1.0
        flot =self.myPow(x,n/2)
        if n % 2 ==0:
            return flot * flot
        else:
            if n > 0:
                return  flot * flot * x


