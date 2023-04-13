# Time Complexity - O(logn)
# space Complexity - O(logn)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        
        if n < 0:
            x = 1 / x
            n = -n
            
        
        result = self.myPow(x, n // 2)
        
        if n % 2 == 0:
            result = result * result
        else:
            result = result * result * x
        
        return result

# Time Complexity - O(logn)
# space Complexity - O(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        
        if n < 0:
            x = 1 / x
            n = -n

        result = 1


        while n != 0 :
            
            if n % 2 == 0:
                x = x * x 
                n = n//2
            else:
                result =  result * x
                n = n -1 
            
        return result
