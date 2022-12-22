#Time complexity: log(n)
#Space complexity: log(n)

#Accepted on leetcode

#Approach
#Frame the problem as a recursive problem such that f(x, even-exponent) = f(x, evenexp/2) * f(x, evenexp/2)
#Similarly, f(x, odd-exponent) = f(x, odd-exp/2) * f(x, odd-exp/2) * x
#Base case => n == 0 then return 1 -> handle edge case for negative exponents (odd numbers handling requried -> multiply by 1/x instead of x)

import math

class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base case
        if n == 0:
            return 1

        #logic
        result = self.myPow(x, n//2 if n > 0 else int(n/2))
        #even power
        if n%2 == 0:
            return result * result
        #odd power
        else:
            if n > 0:
                return result * result * x
            else:
                return result * result * (1/x)
