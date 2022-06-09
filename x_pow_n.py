'''
Approach: If given power is negative, recursive call 1/pow(x,-n) else call pow(x,n) function. In the pow function, recursively call pow function with n//2. In pow function, if n is even multiply the temporary result with itself, else res*res*x. If n reaches 0 return 1

Time complexity: O(logN)
Space complexity:O(logN)

Passes all testcases in leetcode

'''

class Solution:
    def myPow1(self,x: float, n: int) ->float:
        if n == 0:
            return 1.0
        
        res = self.myPow(x,n//2)
        
        if(n%2==0):
            return res*res
        else:
            return res*res*x
        
    def myPow(self, x: float, n: int) -> float:
          
        if(n<0):
            return 1/self.myPow1(x,-n)
        else:
            return self.myPow1(x,n)
        
        
       
