# Time Complexity : O(log(n)) where n is the power that x is raised to
# Space Complexity : O(log(n)) for the recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We can recursively find the half of the power and then multiply it. 
# We also handle the negative power by multiplying it with the inverse of the number.
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        halfExp = self.myPow(x, int(n/2))
        if n % 2 == 0:
            return halfExp * halfExp
        else:
            if n < 0:
                return halfExp * halfExp * (1/x)
            else:
                return halfExp * halfExp * x
        