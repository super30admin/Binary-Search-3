'''
TC: O(n) where n is the number of depth we go to!
SC: O(1)
'''
import math

class Solution:
    def myPow(self, x: float, n: int) -> float:
        #Iteration
        if n<0:
            x = 1/x
        
        result = 1
        while(n!=0):
            if n%2!=0:
                result = result*x
            x = x*x
            if n/2 < 0:
                n = math.ceil(n/2)
            else:
                n = math.floor(n/2)
        return result
s = Solution()
print(s.myPow(2.00000, 10))
print(s.myPow(2.10000, 3))
print(s.myPow(2.00000, -2))