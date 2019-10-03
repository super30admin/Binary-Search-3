# Time Complexity : O(log n) (where n is power of x)
# Space Complexity : O(log n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Simple multiplication exceeds time limit. So, use fast power algorithm.
# - Use recursion and divide power to half each time. We can get original power by multiplyting half.
# - In case of odd power multiply half with half and also multiply base number.


class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
#       If number is positive call helper function directly
        if n > 0:
            return self.helper(x, n)
#       If number is negative call helper function with inverse of base and poitive power
        elif n < 0:
            return self.helper(1/x, -n)
        else:
            return 1
        
    def helper(self, x, n):
#       base case: If we reach at 0 return 1.
        if n == 0:
            return 1
#       Call helper function with half power
        half = self.helper(x, n // 2)
#       If power is even, we can get the full power by multiplying half with half.
        if n % 2 == 0:
            return half * half
#       If power is odd, we can get the full power by multiplying half with half and multiplying the base.
        else:
            return half * half * x
