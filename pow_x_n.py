class Solution:
    
    """Time complexity-O(log(n)) as we are following recursive approach, n is the power
    Space complexity-O(1)"""
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        result=self.myPow(x,int(n/2))
        if n%2==0:
            return result*result
        else:
            if n>0:
                return result*result*x
            else:
                return result*result*(1/x)
        
        # n1=abs(n)
        # if n1==0:
        #     return 1
        # result=self.myPow(x,n1//2)
        # if n1%2==0:
        #     if n>0:
        #         return result*result
        #     else:
        #         return 1/(result*result)
        # else:
        #     if n>0:
        #         return result*result*x
        #     else:
        #         return 1/(result*result*x)
        """Time complexity-O(n) and as n can be very large--> time limit exceeded
        Space complexity-O(1)"""
        # result=1
        # n1=abs(n)
        # for i in range(n1):
        #     result*=x
        # if n<0:
        #     result=(1/result)
        # return result
        
        
            
        