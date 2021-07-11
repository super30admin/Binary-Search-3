# TC: O(logN) :  
# SC: O(logN) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    
    def myPow(self, x: float, n: int) -> float:
        if x==0:
            return 0
        if x==1:
            return 1.0
        
        if n==0:
            return 1.0
        
        if n<0:
            res = self.helper(x,abs(n))
            return 1/res
        else:
            return self.helper(x,n)
    
    def helper(self,x,n):
        if n==0:
            return 1.0
        
        if n%2==0:
            v = self.helper(x,n//2)
            return v*v
        else:
            v = self.helper(x,n-1)
            return x*v
