'''
    Time Complexity:
        O(log n)

    Space Complexity:
        O(log n)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Recursively solve n/2 powers at each step and square the result.
        If n is even, return what you've calculated.
        If n < 0, multiply your current result with 1/x and return it.
        Else, multiply your current result with x and return it.
'''

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1

        sq = self.myPow(x, int(n / 2))
        sq *= sq

        if n % 2 == 0:
            return sq

        if n < 0:
            return sq * (1 / x)

        return sq * x
