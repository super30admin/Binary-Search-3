# // Time Complexity :O(log(n))
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we repeatedly multiply the number with itself until we get the fina val. so if its an even number we multiply the number with itself and divide n/2. 
# else if odd we multiply the number with itself in addition as well
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if(n<0):
            x=1/x
            n*=-1
        res=1
        while(n>0):
            if(n%2 != 0):
                res=res*x
            x=x*x
            n=n/2
        return res