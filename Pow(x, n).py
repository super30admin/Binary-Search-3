# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach: This code calculates 𝑥^𝑛 using binary exponentiation, which reduces the number of multiplications from O(n) to O(log n). If the exponent n is negative, it inverts x to 1/x and makes n positive. In the loop, whenever n is odd it multiplies result by x, then squares x and halves n until n becomes 0, returning the final result.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # TC: O(logn) SC: O(1)
        result = 1.0
        if n == 0:
            return 1
        
        if n < 0:
            x = 1 / x
            n *= -1

        while n != 0:
            if n % 2 != 0:
                result *= x 
            
            x *= x
            n = n // 2
        
        return result