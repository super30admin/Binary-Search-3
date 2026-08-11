# Problem1: Pow(x,n) (https://leetcode.com/problems/powx-n/)
# Time Complexity: O(log n),in each loop we divide n by 2 using n // 2, so the loop only runs about log base 2 of n times instead of n times
# Space Complexity: O(1), we only use a few variables like result, x and n, no extra data structure is created that grows with input size
# Approach:
# If the exponent is negative, we invert x and make n positive since
# x to the power of negative n is the same as one divided by x, all raised to n.
# Then we loop while n is not zero. On each step we square x, which doubles
# how much power that x represents. We only multiply that x into result when
# n is currently odd, since that is the exact step where we need to add that
# factor in based on how the number breaks down in binary.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        result = 1.0   # this will hold our final answer, start at 1 since anything to the power 0 is 1

        if n < 0:      # check if the exponent is negative
            x = 1 / x  # flip x to its reciprocal since x to the power negative n equals one over x, to the power n
            n *= -1    # make n positive now that we have already accounted for
        
        while n != 0:         # keep looping until n has been reduced all the way down to zero
            if n % 2 != 0:    # check if n is currently odd, meaning it leaves a remainder when divided by 2
                result = result * x   # since n is odd, we collect the current value of x into result right now

            x = x * x     # square x, this represents combining two copies of the current power into one bigger one

            n = n // 2     # cut n in half, using integer division to drop any decimal, this shrinks n toward zero fast

        return result   # after the loop ends, result holds the final computed value of x raised to n