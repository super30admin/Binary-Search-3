# Time Complexity : O(log(n))
# Space Complexity : O(log(n))

# The code ran on LeetCode

# Recursively compute X^n by dividing n by 2 until n reaches 1. Return x when n = 1

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            n = abs(n)
            x = (1/x)
        def pow(x, n):
            
            if n == 0:
                return 1
            if n == 1:
                return x
            return (pow(x, n//2)**2)*pow(x, n%2)

        return pow(x, n)