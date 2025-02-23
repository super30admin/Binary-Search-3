#space: O(h)
#Time: O(log(n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        n= int(n)
        if (n == 0):
            return 1.0
        y = self.myPow(x,n/2)
        if (n %2 == 0):
            return y*y
        else:
            if n > 0:
                return y*y*x
            else:
                return y*y*(1/x)
        
