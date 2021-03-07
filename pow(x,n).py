# LOG(N) TIME AND SPACE
class Solution:
    def myPow(self, x , n):
        return self.calPow(x,n) if n > 0 else self.calPow(1/x,-n)
    
    def calPow(self,x,n):
        if n == 0:
            return 1
        recurVal = self.calPow(x,n//2)
        
        if(n % 2 == 0):
            return recurVal * recurVal
        else:
            return recurVal * recurVal * x

