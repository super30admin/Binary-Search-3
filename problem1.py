#time comp- O(logn)
#space- O(1) no extra space
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        #if power n is even 
        if n%2==0:
            t=self.myPow( x, n//2)
            return  t*t
        #if power n is odd
        else:
            #if odd power is positive
            if n>0:
                return self.myPow( x, n-1)*x
            else:
                #if odd power is negative
                return (1/x)*self.myPow( x, n+1)
                
        
