# TC: O(log n)
# SC: O(log n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x==0:
            return 0
        if n<0:
            x=1/x
            n*=-1
        
        def helper(x,n,r):
            #base
            if n==0:
                return 1
            #logic
            xn=helper(x,n//2,r)
            if n%2==0:
                r=xn*xn
            else:
                r=xn*xn*x
            
            return r

        return helper(x,n,0)