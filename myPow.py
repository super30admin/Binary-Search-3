"""
Time complexity = O(log N)
Space complexity =0(1)

recursively find power by dividing N by 1/2.
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base
        
        if n==0:
            return 1.0
        if n<0:
            return 1/self.myPow(x, -n)
        #logic
        temp=self.myPow(x,n//2)
        if(n%2==0):
            return temp*temp
        else:#odd
            if(n<0):#negative
                return temp*temp*(1/x)
            else:
                return temp*temp*x
        
            
        