class Solution:
    # Time Complexity: O(log n)
    # Space Complexity: O(1)
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n *= -1
        result = 1.0
        while n > 0:
            if n % 2 != 0:
                result = result * x
            x *= x
            n //= 2
            print(n)
        return result
