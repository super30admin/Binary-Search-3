"""
Iterative approach Practice
TC - O(log n) since reducing computation to n/2
SC - O(1)
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1

        # if n is -ve
        if n < 0:
            # we dont use // here since we need the decimals
            x = 1 / x
            # n = -(-2) = 2
            n = -n

        ans = 1
        while n:
            # if n is odd
            if n % 2:
                ans *= x

            x *= x

            n //= 2

        return ans