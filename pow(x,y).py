#Time Complexity: O(logn)
#Space Complexity: recursion stack
class Solution:
    def myPow(self, x: float, n: int) -> float:
       
        if n == 0:
            return 1

        result = self.myPow(x, int(n/2))
        
        if n%2 != 0:
            if n<0:
                return result*result*1/x
            else:
                return result*result*x
            
        elif n%2 == 0:
            return result * result