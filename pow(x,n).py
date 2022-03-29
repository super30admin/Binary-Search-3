# // Time Complexity : O(log n)
# // Space Complexity : O(log n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def myPow(self, x, n):
        def helper(x, n):
            if x == 0: return 0
            if n == 0: return 1
            
            # recursion
            res = helper(x*x, n // 2)
            return x * res if n % 2 else res  # multiply x if n is odd
        
        res = helper(x, abs(n))
        return res if n >= 0 else 1/res # if n is negative return log