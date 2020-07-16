"""
    Student : Shahreen Shahjahan Psyche
    Time    : O(log N) [binary search]
    Space   : O(1) [No Auxiliary Space Has Been Used]
              
    Pased Test Cases : Yes
    
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        # base case
        if n == 0:
            return 1
        
        # calling recursive function after halfing n
        temp =  self.myPow(x, int(n/2))
        
        # if n is even
        if n%2 == 0:
            return temp * temp
        else:
            # if n is positive
            if n > 0:
                return temp * temp * x
            else:
                return temp * temp * (1/x)

        
        
        
