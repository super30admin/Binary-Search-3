# Time Complexity o(logn)
# Space Complexity o(logn)
class Solution:
    def myPow(self, x: float, n: int) -> float:
#       base case 
        if n == 0:
            return 1.0
        
        if n < 0:
            x = -1/x
            n = -n
#      Logic   
        result = self.myPow(x,n//2)
        
        if (n%2) == 0:
            return result * result
        else:
            if n > 0:
                return result * result * x
            else:
                return result * result * (x)
            
            