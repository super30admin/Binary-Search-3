class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n<0:
            x=1/x
            n=-n
            
        return self.power(x,n)
        
        
    def power(self,x,n):
        
        if n==0:
            return 1
        
        result=self.myPow(x,n//2)
        
        if n%2==0:
            return result*result
        else:
            return x*result*result
        