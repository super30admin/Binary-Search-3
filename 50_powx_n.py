"""
Problem: 50. Implement pow(x, n), which calculates x raised to the power n (i.e. x^n)
Leetcode: https://leetcode.com/problems/powx-n/

Approach:
    - Calculate square root, use it to calculate square.
    - For even n, x^n = x^n/2 * x^n/2
    - For odd n, x^n = x^n/2 * x^n/2 * x
    - If n is negative, change x to 1/x and negative n to positive n

Time Complexity: O(log n) for the recursive calls till n//2
Space Complexity: O(log n) recursive stack

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1

        # if n is negative
        if n < 0:
            x = 1 / x
            n = -n

        # Calculate square root
        sqrt = self.myPow(x, n // 2)

        # if n is even
        if n % 2 == 0:
            return sqrt * sqrt
        # if n is odd
        else:
            return sqrt * sqrt * x
