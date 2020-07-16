# Time Complexity :average O(logn)
# Space Complexity :O(logn)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        # anything power 0 = 1
        if  n ==0:
            return 1
        # if power negative 1/x to change power to _ve
        if n <0:
            return self.myPow(1/x,-n)
        # get the sol of half the power
        temp = self.myPow(x,n/2)
        if n%2 == 0:
            # if power is even
            return temp*temp
        else:
            # if power is odd
            return temp*temp*x