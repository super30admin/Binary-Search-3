# Time Complexity : O(log N) where N is the input
# Space Complexity : O(log N) where N is the input
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using recursion to calculate the power.
# I am checking if the power is 0, if it is, I return 1.
# I am calculating the power of x raised to n//2 and storing it in power.
# I am multiplying power with itself to get the final answer.
# If n is odd, I multiply the answer with x.
# If n is negative, I return the reciprocal of the answer.

from typing import List
class Solution:
    def myPow(self, x: float, n: int) -> float:
        ans = 0
        if n == 0:
            return 1
        power = self.myPow(x,abs(n)//2)
        ans = power*power
        if abs(n) % 2 == 1:
            ans *= x
        return ans if n>0 else 1/ans