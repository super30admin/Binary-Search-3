# TC: O(LOG(N))
# SC: O(LOG(N))

class Solution:
    def helper(self,x,n):
        
        if n==0:
            return 1
        
        if n<0:
            n=n*-1
            x=1/x
            
        res=self.helper(x,n//2)
        if n%2==0:
            return res * res
        else:
            return res * res * x

    def myPow(self, x: float, n: int) -> float:
        return self.helper(x,n)
        