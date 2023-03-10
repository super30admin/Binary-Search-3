	#All TC on leetocde passed
	
	class Solution:
    def myPow(self, x: float, n: int) -> float:

        #Here we use recurssion. We call the same parent function by reducing n to half each time. 
        #Once n reaches 0 we return 1. If n is -ve then we make it positive and change 
        #x to 1/x to accomodate -ve values.
        #Time complexity - O(logn)
        #Space complexity - O(logn) - stack space

        if n<0:
            x = 1/x
            n = n*-1

        if n==0:
            return 1

        result = self.myPow(x,n//2)
        
        if n%2==0:
            result = result*result
        else:
            result = result*result*x
        return result
        