# Time Complexity: O(logn)
# Space Complexity: O(log n)

# Issue Faced: Have to handle negative power case differently in python
#              Exceeded recursion depth when I followed logic discussed in class
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if(n < 0):
            return self.myPow(1/x, -n)
        if(n==0):
            return 1
        
        # logic
        temp = self.myPow(x, n//2)
        
        # Even case
        if(n%2 == 0):
            return temp * temp
        
        # Odd case
        else:
            # if(n < 0):
            #     return temp * temp * (1/x)
            # else:
            return temp * temp * x