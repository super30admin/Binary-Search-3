import math
#Time complexity is: O(log(n))
#Space complexity is: O(log(n))
#Code ran successfully on leet code
#No issues faced while coding
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        #base
        if(n==0):
            #if n is equal to 0, we return 1.0
            return 1.0
        #logic
        if(n<0): 
            #if n is less than 0, we will first make that positive and we will send to the funct fucntion
            n*=-1
            #While returning the result, we will do 1/result
            return 1/self.funct(x,n)
        else:
            #otherwise we will just call the below fucntion by sending required parameters
            return self.funct(x,n)
        
    def funct(self,x,n):
        if(n==0):
            #if n is equal to 0, we return 1.0
            return 1.0
        #We will call the below function recursively
        temp=self.funct(x,n//2)    
        #If n is divisible by 2, we will return temp*temp
        if(n%2==0):
            return temp*temp
        else:
            #If n is less than 0, we will return below values based on the conditions
            if(n<0):
                a=1//x
                return temp*temp*a
            else:
                return temp*temp*x
