'''
TC: O(n) where n is the number of depth we go to!
SC: O(n)
'''
import math

class Solution:
    def myPow(self, x: float, n: int) -> float:
        #Recursion
        if n<0:
            x = 1/x

        def recurse(x,n):
            #base
            if n==0:
                return 1
            #logic
            if n/2 <0:
                result = recurse(x,math.ceil(n/2))
            else:
                result = recurse(x,math.floor(n/2))
            if n%2==0:
                return result*result
            else:
                return result*result*x

        return recurse(x,n)
s = Solution()
print(s.myPow(2.00000, 10))
print(s.myPow(2.10000, 3))
print(s.myPow(2.00000, -2))