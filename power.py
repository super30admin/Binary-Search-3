# Time Complexity - O(log n)
# Space Complexity - O(n) 
# Approach : Recursion

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0:
            return 1
        
        temp = self.myPow(x, int(float(n)/2))
        
        if n%2==0:
            return temp*temp
        else:
            if n<0:
                return temp*temp*(1/x)
            else:
                return temp*temp*x
            