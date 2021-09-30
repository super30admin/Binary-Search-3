#Time Complexity : O(log n)
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        if n>0:
            p = floor(n/2)
        else:
            p = -floor(abs(n)/2)
        res = self.myPow(x, p)
        if n%2 == 0:
            return res*res
        else:
            if n>0:
                return res*res*x
            else:
                return res*res/x