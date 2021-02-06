class Solution:
    # Divide and Conquor: Time Complexity: log(n) # Space Complexity: O(1)
    def myPow(self, x: float, n: int) -> float:
        if(n==0):
            return 1
        if(n==1):
            return x
        if(n<1):
            x = 1/x
            n = n* -1
            
        
        def pow1(x,n):
            if(n==1):
                return x
            if(n==0):
                return 1
            
            if(n%2==0):
                num = pow1(x,n//2)
                return num*num
            else:
                num = pow1(x,(n-1)//2)
                return num*num*x
        
        return pow1(x,n)
