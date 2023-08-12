#Time Complexity :O(log(n))
#Space Complexity :O(1) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n<0:
            n*=-1
            x=1/x

        result=1.0

        while n!=0:
            if n%2!=0:
                result=result*x
            x=x*x
            n=n//2

        return result
