# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from math import floor


class Solution:
    def myPow(self, x: float, n: int) -> float:

        # base case
        if n == 0:
            return 1

        if n > 0:
            p = floor(n/2)
        else:
            p = -floor(abs(n)/2)

        result = self.myPow(x, p)

        # logic
        if n % 2 == 0:
            return result * result

        else:
            if n > 0:
                return result * result * x  # if the power value is positive
            else:
                return result * result / x  # if the power value is negative
