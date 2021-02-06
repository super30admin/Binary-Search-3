#time: O(logn)
#space: O(1)
import math
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if (n==0):
            return 1
        
        if(n<0):
            val=self.myPow(x,math.ceil(n/2))
        else:
            val=self.myPow(x,n//2)
        print(val,n)
        if(n%2==0):
            return val*val
        else:
            if(n<0):
                return val*val*(1/x)
            else:
                return val*val*x
            
            
        
        