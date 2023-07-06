"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


dividing the power in each iteration and squaring the number to accomodate power reduction
If odd power encontered, multiplying the result again with x, which represents current value of x at current power
returning result in the end

"""


# Pow(x,n)


class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n<0:
            x=1/x
            n=-1*n
        result=1
        while n>0:
            if n%2==1:
                result=result*x
            x=x*x
            n=n/2
        return result