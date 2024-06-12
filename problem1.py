'''
Time Complexity: O(log(n))
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Use Divide and conquer to find the power of n by splitting it to n/2. Use a condition for even and odd numbers
'''

class Solution:
    def power(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n == 1:
            return x

        val = self.power(x, n / 2)

        if int(n % 2) == 0:
            return val * val
        else:
            return x * val * val

    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            if n == 0:
                return 1
            x = 1 / x
            n = -1 * n

        return self.power(x, n)
