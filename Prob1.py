# Time Complexity : O(log(n))
# Space Complexity : O(log(n))

class Solution:
    def myPow(self, x: float, n: int) -> float:
       # Method 1 - Recursive Pattern
        # if n==0: return 1
        # if n<0: #if n is negative, flip x and make n positive for ease of recrusion.
        #     x=1/x
        #     n=-n
        # res=self.myPow(x,n//2)
        # if n%2==0: #if n is even, res*res
        #     return res*res
        # else:   
        #     return res*res*x #if n is odd res*res*x


        if n==0: return 1
        if n<0: #if n is negative, flip x and make n positive for ease of recrusion.
            x=1/x
            n=-n
        res=1
        while n>0:
            if n%2==1: #if odd mul to res
                res=res*x
            x=x*x #each time multiply x with itself and do n divided by 2
            n=n//2
        return res




        


