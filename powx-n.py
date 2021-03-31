"""
TC: O(1) or O(n) not sure
SC: looks like O(1) but could be O(n) as behind the scenes the multiplication might take up space (recursion stack maybe). Not Sure.
Leetcode: Success
Problems: With the edge case for max size. 
"""

class Solution:
    def myPow(self, x: float, n: int) -> float:
        # power of n in python
        y = (x**n)
        return y;

      """
      ASLO TRIED: 
      
        result = x
        if n == 0:
            return 1.00000
        elif n > 0:
            for i in range(n-1):
                result *= x
            return round(float(result),5)
        else: 
            n = abs(n)
            for i in range(n-1):
                result *= x
            result = 1/result
            return round(float(result),5)"""
