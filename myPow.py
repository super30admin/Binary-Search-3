class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0:
            return 1 
        if n<0:
            return 1/self.myPow(x, -n)
        temp = self.myPow(x, n//2)
        if n%2 == 0:
            return temp * temp
        else:
            if n<0:
                return temp * temp * (1/x)
            else:
                return temp * temp * x
            
          Time: O(logn)
          Space : O(logn)
