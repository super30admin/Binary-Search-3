"""
50. Pow(x, n)
Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

Time Complexity: O(logn) where n = number of elements in input array
Space Complexity : O(1) 
Successfully excecuted on leetcode


Approach:
1. Recursion
2. Three cases - If n is negative, recurse with negative n. If n is even, recurse with n-1. If n is odd, recurse with n/2 

"""

class Power:
    def myPow(self, x: float, n: int) -> float:
        if not n:
            return 1
        if n < 0:
            return 1 / self.myPow(x, -n)
        if n % 2:
            return x * self.myPow(x, n-1)
        return self.myPow(x*x, n/2)
    