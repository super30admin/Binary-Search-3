class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        #O(logn)>divide and conquer
        #O(n)>stack space
        #0 raise to anything is 1
        if n==0:
            return 1
        #negative numbers>take reverse at start only
        if n<0:
            x=1/x
        #2*10=(2*5)(2*5)
        def helper(x,n):
            #base
            if n==0:
                return 1
            #take half and compute till reaches base case
            step1=helper(x,n/2)
            #if odd number, multiply that number to answer again
            if n%2==1:
                step2=step1*step1*x
            else:
                step2=step1*step1
            return step2
        #since already taken care of negative number
        return helper(x,abs(n))
        