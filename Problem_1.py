# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        p = 1
        c = abs(n)
        while c:
            p, c = ((p * x), (c - 1)) if (c % 2) else (p, c)
            x = (x * x)
            c = (c // 2)
        return p if (n >= 0) else (1 / p)