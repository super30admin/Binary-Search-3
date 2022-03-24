TC: O(log(n))
SC: 0
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def pow(x:float, n:int) -> float:
            # base
            if ( n==0) : return 1.00 
            # logic
            result = pow(x,int(n/2))
            if (n%2==0): return result*result 
            else:
                if(n>0):
                    return result*result*x
                else:
                    return result*result*(1/x)
        return pow(x,n)
        
        

    
    
        