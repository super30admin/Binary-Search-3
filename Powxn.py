class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        '''Time Complexity: O(log n)
        Space Complexity: O(log n )'''
        #Base Case
        if n==0:
            return 1
        #If the n is negative then make n positive and x will be 1/x as n is -ve
        if n < 0:
            n*=-1
            x=1/x
        
        #Logic
        #Recursively call half 
        result=self.myPow(x,n//2)
        
        if n % 2 == 0:
            return result * result
        else:
            return result * result * x
            
