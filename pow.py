#Time complexity: O(log n)
#space complexity: O(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0:
            return 1.0
        
        #logic
        res = self.myPow(x, int(n / 2))
        if n % 2 == 0:
            return res * res 
        else:
            if n < 0:
                return res * res * (1/x)
            else:
                return res * res * x
        
        
