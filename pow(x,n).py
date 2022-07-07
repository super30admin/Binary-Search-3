#50. Pow(x, n)
"""
Time Complexity : O(logn)
Space Complexity : O(1)
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        #base
        if (n == 0):
            return 1.000
        #if (n == -1):
         #   return -1.000
        #logic
        result = self.myPow(x, int(n/2) )
    
        if n % 2 == 0: #n is even
            return result*result
        else: #n is odd
            if n < 0:
                return result*result*(1/x)
            else:
                return result*result*(x)
            
