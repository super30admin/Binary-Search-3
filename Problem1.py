# // Time Complexity : O(logn) where n is the power.  
# // Space Complexity : O(logn) where n is the power.  
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x,n):
            if n == 0:
                return 1
            res = helper(x,int(n / 2))

            if n %2 == 0:
                return res * res
            else:
                if n > 0:
                    return res * res * x
                else:
                    return res * res * (1/x)
                
        return helper(x,n)
