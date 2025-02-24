# Time complexity - O(logn)
# Space complexity - O(logn) # if considering recursive stack, else O(1)

# Approach - Compute the power recursively for n=n//2, when you hit the base case i.e. n == 0, return
# result, depending on whether n was odd or even to begin with.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x == 0:
            return 0
        if n == 0:
            return 1
        if n < 0:
            x = 1/x
            n = -1 * n
        
        result = self.myPow(x, n//2)
        
        if n%2 == 0:
            result *= result
        else:
            result *= result * x
        return result