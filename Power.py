# Time Complexity :O(LogN)
# Space Complexity :O(LogN)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if(n==0):
            return 1.0
        if(n<0):
            x=1/x
            n=-1*n
        # a=self.myPow(x, n//2)
        if(n%2):
            return self.myPow(x*x, n//2)*x
        return self.myPow(x*x,n//2)