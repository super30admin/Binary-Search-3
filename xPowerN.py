class Solution(object):
    # recrussive approach to find the power wil be O(logn) both time and space 
    # doign an iterative approach we can reduce the recrusive stack space from logn to 1
    # tc : o(logn), sc : O(1)
    def myPow(self, x, n):
        result = 1.0 

        if n <0:
            n = -n
            x = 1/x
         
        while n!=0:
            if n%2 != 0: # if the power is of even number 
               result *=x 
            
            x*=x # we will square the x so the while loop by the end x will be square at each step and if our power is odd we need to ultip x one more time
            n = n//2 # reduce the n by 2 

        return  result 
        