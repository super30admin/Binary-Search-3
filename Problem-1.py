# 50. Pow(x, n)


# Code:

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n<0:
            n = -n
            x = 1/x
        return self.helper(x, n)
        
        
    def helper(self, x, n):
        # base case
        if n==0:
            return 1
        
        # recursive case:
        
        res = self.myPow(x, n//2 )
        
        # res = odd or even?
        if n%2==0:
            return res*res
        else:
            # check positive or negative!
            if n<0:
                return res*res*1/x
            else:
                return res*res*x
        

# Time Complexity: O(logN)
# Space Complexity: O(1) -> with recursive stack -> O(logN)
# Accepted on Leetcode: Yes.