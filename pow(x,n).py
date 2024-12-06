# Approach:
# Use the divide-and-conquer strategy for calculating x^n efficiently. If n is negative, we compute the reciprocal of x raised to -n.
# Recursively split the problem into smaller parts: x^n can be broken down into (x^(n//2))^2 for even n, or x * (x^(n//2))^2 for odd n.
# This reduces the time complexity from O(n) to O(log(n)).

# Time Complexity: O(log(n)), as the problem size is halved at every step.
# Space Complexity: O(log(n)), due to the recursive stack.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Handle the case when n is negative
        if n < 0:
            x = 1 / x
            n = -n
        
        # Helper function for recursive computation
        def power(x, n):
            # Base case: anything to the power of 0 is 1
            if n == 0:
                return 1
            # Recursive case: calculate x^(n//2)
            half = power(x, n // 2)
            # If n is even, result is half * half
            if n % 2 == 0:
                return half * half
            else:  # If n is odd, include an extra x
                return half * half * x
        
        # Calculate the result using the helper function
        return power(x, n)
