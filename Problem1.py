# Time Complexity : O(log n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """

        if n < 0:
            # x = 1/x
            # n = -n
            return self.myPow(1 / x, -n)

        if n == 0:
            return 1

        res = self.myPow(x, n // 2)
        if n % 2 == 0:
            return res * res
        else:
            return x * res * res

# In this problem, I have used binary search. The result is divided into two parts and its value is returned. If the
# value of n is nagatie then the x value is inversed and the n value is made positive.