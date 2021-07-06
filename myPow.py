# Time Complexity : O(log(n))
# Space Complexity : O(log(n))
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# This is a very straight forward recursive approach, where the case
# of even, odd & negative power are handled. The power is divided
# by 2 every time, the result is reused for odd and even powers.
class Solution(object):
    def myPow(self, x, n):
        if n == 0:
            return 1
        if n < 0:
            return self.myPow(1 / x, (n * -1))

        result = self.myPow(x, n / 2)
        if n % 2 == 0:
            return result * result
        else:
            return result * result * x
