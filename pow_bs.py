class Solution:
    def myPow(self, x: float, n: int) -> float:
        """"
        2(9)= 2(4)*2(4)*2 odd powers
        2(4)= 2(2)*2(2)   even powers
        2(2)= 2(1)*2(1)
        2(1)= 2(0)* 2(0)* 2
        handling odd, even
        +ve, -ve cases of n -> 1/posval
        """
        #recursion
        #base
        """if n==0:
            return 1.0
        if n<0:
            x= 1/x
            n=-n #not caring that its -ve
        result= self.myPow(x,n//2)
        #logic
        if n%2==0:
            return result*result
        else:
            return result *result *x"""

        #loop
        result= 1.0
        #we're going to be mult all the extra x in odd case here, 2^1 is odd so no issue
        #finally everything will be stored
        if n<0:
            n=-n
            x=1/x

        while n>0:
            if n%2!=0:
                result*=x
            x=x*x
            n=n//2
            
        
        return result