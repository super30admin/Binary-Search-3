'''
Solution:
1.  To calculate pow(x, n), instead of performing a linear computation by multiplying x from 1 to n times, we can
    perform binary computation by multiplying x twice in a function call to reduce the computation time to logn from n.
2.  Just need to handle the cases where n is negative and also when n is odd.

Time Complexity: O(logN) | Space Complexity: O(logN)

--- Passed all testcases successfully on leetcode
'''


class Solution:
    def myPow(self, x: float, n: int) -> float:

        #   invert x when n is negative
        if (n < 0):
            if (x == 0):                #   handle when x is 0 while n being negative
                return float('inf')
            x = 1 / x
            n = -1 * n

        #   base cases of when n is 0 and n is 1
        if (n == 0):
            return 1
        if (n == 1):
            return x

        #   perform recursion on n/2 and extract the value
        val = self.myPow(x, int(n / 2))

        #   if n is even, multiply the previous obtained value with itself otherwise if n is odd, multiply an extra x
        if (n % 2 == 0):
            return val * val
        else:
            return x * val * val