class Solution:
    def myPow(self, x, n) :
       #base
        if n==0:
            return 1
        #logic
        result=self.myPow(x,int(n/2))
        if n%2==0:                  #greater than 0 and even
            return result*result
        elif n>0 :                  #greater than 0 and odd
            return result*result*x
        else:                       #negative
            return result*result*1/x