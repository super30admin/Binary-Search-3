# 50. Pow(x, n)
# https://leetcode.com/problems/powx-n/

# Logic: Half the power and calculate the value. Take care of if the power is odd or even.

# Time Complexity: O(log n)
# Space Complexity: O(log n) [system stack]

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            n *= -1
            x = 1/x
        
        # Base Case x^0
        if n == 0:
            return 1
        
        temp = self.myPow(x, n//2)
        
        if n % 2 == 0:
            return temp * temp
        else:
            return temp * temp * x
