#time complexity: O(log(n))
#space complexity: O(1)
#ran on leetcode: Yes
#At each recursion reduce the size by half and return the result.
class Solution:
    def Pow(self,x,n):
        if(n==0):
            return 1
        if(n%2==1):
            return self.Pow(x*x,n//2)*x
        else:
            return self.Pow(x*x,n//2)
    def myPow(self, x: float, n: int) -> float:
        
        if(n<0):
            x=1/x
            n=-n
        return self.Pow(x,n)
        
