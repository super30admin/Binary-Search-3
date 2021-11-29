#Time complexity O(logn), space O(logn)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n<0:
            x=1/x
            n=-n
        return self.helper(x,n)
 
#computations
    def helper(self,x,n):
        
        if n==0:
            return 1
        
        t=self.myPow(x,n//2)
        if n%2 == 0:
            return t*t
        else:
            return t*t*x
