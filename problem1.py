class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        #base case
        if n==0:
            return 1
        
        #logic
        x1=self.myPow(x,abs(n)//2)
        
        if n>0:
            if n%2==0:
                return x1*x1
            else:
                return x1*x1*x
        else:
            if n%2==0:
                
                return 1/(x1*x1)
            else:
                
                return 1/(x1*x1*x)
            
            
