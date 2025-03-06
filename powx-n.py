# Time O(log n)
# Space O(log n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0: 
            x = 1/x
            n = -n
        if n == 0: 
            return 1.0
        res = self.myPow(x, n//2)
        if n%2 !=0:
            res = res * res * x
        else: res = res * res
        return res 
    
# Time O(log n)
# Space O(log n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0: 
            return 1.0
        res = self.myPow(x, int(n/2))
        if n%2 !=0:
            if n > 0:
                res = res * res * x
            else:
                res = res * res * 1/x
        else: res = res * res
        return res 
    
# Time O(log n)
# Space O(1)   
class Solution:
    def myPow(self, x: float, n: int) -> float:
        res = 1
        if n < 0: 
            x = 1/x 
            n =-n
        while n > 0:
            if n%2 != 0:
                res = res * x
            x *= x
            n = n//2
        return res