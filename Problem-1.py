"""
Approach: Bottom up approach

1) 2 ^ 8 can be written as 2^4 * 2^4
2) recursively break the problem until you reach n == 0.
    a) (anything)^0 is 1
3) Note that x needs to be reciprocted if n is negative
    a) This can be handled in the begining itself

TC: O(log n)
SC: O(log n) in recursive stack
"""

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # handle reciprocation if n is a fraction
        if n<0:
            n = n * -1
            return 1/self.helper(x,n)

        return self.helper(x,n)

    def helper(self, x, n):
        if n == 0:
            return 1

        #logic
        result = self.myPow(x, n//2)
        # if even
        if n % 2 == 0:
            return result * result

        # if odd
        else:
            return result * result * x