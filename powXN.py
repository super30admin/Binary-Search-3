# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach : Recursion
# Here we use recursion to calculate the power of x raised to n.
# At each recursion step, we divide n by 2 and calculate the power of x raised to n//2.
# If n is even, we return the square of the result.
# If n is odd, we return the square of the result multiplied by x.
# If n is negative, we return the reciprocal of the result.
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # If x is 0, return 0
        if x == 0:
            return 0

        # Recursive function to calculate the power
        def pow(x, n):
            # Base case: if n is 0, there is no power to calculate so we return 1
            if n == 0:
                return 1
            # Calculate result for n//2 by recursion
            res = pow(x, n//2)
            # If n is odd, we return the result multiplied by itself and by x to the previous result
            if n % 2 != 0:
                return res * res * x
            # If n is even, we return the result multiplied by itself
            else:
                return res * res
        # If n is negative, we return the reciprocal of the result
        # Otherwise, we return the result
        return pow(x, abs(n)) if n >= 0 else 1/pow(x, abs(n))

# Time Complexity : O(logn)
# Space Complexity : O(1)

# Approach : Iteration
# In this approach, we use an iterative method to calculate the power of x raised to n.
# At each iteraton, we update the result by it's square and divide n by 2.
# If n is odd, we collect the additional occurances of x (x^5 = x^2 * x^2 * x -> 1 additional occurance)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Initialize result
        res = 1
        # If n is negative, we calculate the reciprocal of x
        if n < 0:
            x = 1/x
            # We also need to make n positive
            n = n * -1

        while n != 0:
            # Whenever we encounter an odd occurance of n, we update the result with product of itself and the calculated x so far
            if n % 2 != 0:
                res = res * x
            # At each iteration, we calculate the square of x
            x = x * x
            # And divide n by 2
            n = n // 2
        # Finally, we will have calculated x^n, and stored in res, return it.
        return res