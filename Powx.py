# Time Complexity : O(logN) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA
# Approach is to find the power by iteratively multiplying the number.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        t=1
        if (n<0):
            x=1/x
            n=n*-1

        while(n>0):
            if(n%2!=0):
                t=t*x    
            x=x*x
            n=n//2

        return t