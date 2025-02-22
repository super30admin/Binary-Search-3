# Time Complexity : O(log n) because we are dividing by 2
# Space Complexity : O(log n) - recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# recursive solution - break down the given problem to something that's value is known, example - x^0 = 1
# for even values of x - we do x ^ (n/2) * x ^ (n/2)
# for odd values of x - we do x ^ (n/2) * x ^ (n/2) * x
# but when x is negative, the process is same, just in case of negative odd - we have to do 1/x

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        # base case
        if n == 0:
            return 1.0

        # negative value, we change x to 1/x
        if n < 0:
            x = 1/x
            n = -n

        # logic
        # recursively  multiplying by x ^ (n/2)
        y = self.myPow(x, n // 2)
        if n % 2 == 0:
            # even
            return y * y
        else:
            # odd - multiply by either x or 1/x (1/x for -ve)
            return y * y * x
                

        