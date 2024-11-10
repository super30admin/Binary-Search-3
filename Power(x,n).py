"""
Brute force: time limit exceeds.

Recursive approach: divide the n into half and check if power is even or odd
and based on that calculate the multiplicaiton.
2^0 = 1
2^1 = 2
2^2 = 2 * 2
2^3 = 2^2 * 2
2^4 = 2^2 * 2^2
2^5 = 2^3 * 2^3 * 2
TC: O(log(n)) divide the power into half
SC: O(log(n)) recursive call/stack space
Todo: iterative approach
"""


class Solution_recursion:
    def helper(self, power_left, x):  # (0,2) (1,2) (2,2) (5, 2)
        if power_left == 0:
            return 1

            # if power is even
        if power_left % 2 == 0:  # (2,2)
            even_half = self.helper(power_left // 2, x)  # (1,2)
            self.ans = even_half * even_half
            return self.ans

        elif power_left % 2 != 0:
            odd_half = self.helper(power_left // 2, x)  # (0,2) (2,2)
            self.ans = odd_half * odd_half * x
            return self.ans

        return self.ans  # 2

    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = n * (-1)

        self.ans = 1
        self.helper(n, x)  # 5 , 2

        return self.ans


class brute_force:
    def myPow_bruteForce(self, x: float, n: int) -> float:
        if n < 0:
            n = -1 * n
            x = 1 / x

        ans = 1
        for i in range(n):
            ans *= x

        return ans