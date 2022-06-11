'''
Time Complexity: 0(logn)
Space Complexity: Recursion Stack

Solution Approach:
1. We can solve it in a linear way i.e. multiply x till we reach limit n
2. Better approach is a recursion way. You divide your factor n by 2 and cal the result
   You need to take care of the negative case i.e. when n is negative, my x will be 1/x
'''

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        # base-case
        if n == 0:
            return 1
        
        '''calculate result'''
        # if my n is -ve, my x will be a fraction
        if n < 0:
            
            # convert x to fraction
            x = 1/x
            
            # make n as +ve
            n = -1 * n
            
        result = self.myPow(x, int(n/2))
        #----------------------------
        
        # logic-case
        # Case 1: n is odd
        if n%2 != 0:
            return result*result*x
        
        # Case 2: n is even
        elif n%2 == 0:
            return result * result 