class Solution:
    '''
        2^a * 2^b = 2^(a+b)
        power = 10 if we divide it into 2, we want to know the power of 5, for 5 we want to know the power of 2 and for 2, we should know 1 and anything to the power 0 is 1
        Divide and conquer approach
        2^0 = 1 (Base case)
        2^1 = 2 (Odd Power)
        2^2 = 2*2 (Even Power)
        2^5 = (2*2)*(2*2)*2 (Odd Power)
        2^10 = 2^5 * 2^5 (Even Power)
        
        Therefore, for multiply the previous result by itself and for odd case multiply the previous result to itself and then multiply with an extra 2
        
        Instead of base 2, we can take any base but logic will remain same
        
        Time Complexity - O(log n)
        Space Complexity - O(log n) (stack space)
        
        '''
    def myPow(self, x: float, n: int) -> float:
        
        if n==0:
            return 1.0 
        
        if n<0:
            x=1/x
            n=-1*n
            
        return self.helper(x,n)
    
    def helper(self,x,n):
        
        if n == 0:
            return 1.0
        
        half = self.helper(x,int(n/2))
        
        if n%2 == 0:
            return half*half
        else:
            return half*half*x
        
        
        '''
        Brute Force
        Time Complexity - O(N)
        Space Complexity - O(1)
        Gives TLE on leetcode
        
        if x == 0:
            return 0
        
        res=1
        
        for i in range(0,abs(n)):
            if n>0:
                res=res*x
            else:
                res=(res*(1/x)) 
            
        return res
        
        '''
            
        
        
       