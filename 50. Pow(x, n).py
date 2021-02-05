# // Time Complexity : O(logn)
# // Space Complexity : O(logn)
# // Did this code successfully run on Leetcode : No
# // Any problem you faced while coding this : I am not sure whats is wring here its failing for 2^-2


# // Your code here along with comments explaining your approach
	# Recurse from the highest power to lowest by halving at each step

class Solution:
    def myPow(self, x: float, n: int) -> float:
        ## stoping
        if n == 0:
            return 1
        ## Recurse:
        res = self.myPow(x,n//2)
        if n % 2 == 0:
            return res * res
        else:
            if n < 0:
                return res * res * (1/x)
            else:
                return res * res * x