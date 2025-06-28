# Time complexity: O(log n), where n is the absolute value of the exponent.
# Space complexity: O(1), as we only use a constant amount of space.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = -n
        result = 1
        while n > 0:
            if n % 2 == 1:
                result *= x
            x *= x
            n //= 2
        return result

