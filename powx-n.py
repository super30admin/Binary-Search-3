# Time Complexity : O(logn)
# Space Complexity : O(logn) - for recursion stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Recursion
"""


class Solution(object):
    def myPow(self, x, n):
        if n == 0:
            return 1.0

        if n < 0:
            x = 1/x
            n = -n

        temp = self.myPow(x, n // 2)

        if n % 2 == 0:
            return temp * temp
        else:
            return temp * temp * x