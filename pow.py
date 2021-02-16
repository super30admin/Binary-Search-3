#Time Complexity: O(logn)
#Space Complexity: O(1)
#Run on Leetcode: Yes
#Any Issues: No

from collections import deque

class Solution:
    def myPow(self, X: float, N: int) -> float:
        
        if N == 0:
            return 1
        elif N < 0: 
            X = 1/X
            N *= -1

        dp = {0: 1.0, 1: X, 2: X*X}
        powers = [0, 1, 2]

        n = 1
        while n + n <= N:
            dp[n+n] = dp[n] * dp[n]
            n *= 2
            powers.append(n)

        if N in dp:
            return dp[N]

        ans = 1
        while N > 0:
            for p in reversed(powers):
                if N - p >= 0:
                    ans *= dp[p]
                    N -= p
        return ans