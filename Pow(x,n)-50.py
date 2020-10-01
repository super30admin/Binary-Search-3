# Time Complexity : O(logn)
# Space Complexity : O(1) -> O(logn) for recurisve stack 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  return val for even and val * x for odd. Also check for n if it's negative return 1/ans
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        def helper(x, n):
            if n == 0:
                return 1
        
            val = helper(x, n//2)

            if (n%2) == 0:
                return val * val
            else:
                return val * val * x
        
        ans = helper(x, abs(n))
        if n < 0:
            return 1/ans
        return ans
