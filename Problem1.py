"""
I used the Exponentiation by Squaring technique to optimize power calculation.
In each step, I square the base and halve the exponent to reduce the number of multiplications.
Time Complexity: O(log n)
Space Complexity : O(1)
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n < 0:
            x = 1 / x
            n = -n
        result = 1.0
        while n > 0:
            if n % 2 == 1:
                result *= x
            x *= x
            n //= 2
        return result