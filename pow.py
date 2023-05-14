# Time Complexity: O(log n)
# Space Complexity: O(log n) for recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We find the power of a number by creating a recursive function that divides the power by 2 and calls itself. 
If the power is less than 0, we make it positive and set a flag to true. Once we get the answer from the recursive
 function, we check if the power is odd or even and multiply to get the result accordingly. 
"""

class Solution:
    def __init__(self):
        self.isNegative = False

    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n < 0:
            n = -n
            self.isNegative = True
        result = self.myPow(x, n // 2)

        if n % 2 == 0:
            return result * result
        else:
            if self.isNegative == True:
                return result * result * (1/x)
            else:
                return result * result * x