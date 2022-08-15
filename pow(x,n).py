# Time complexity: O(log n)
# space complexity: O(log n)-recursive stack
# Approach: keep dividing the n until it becomes 0 
# if n is odd, yn = yn/2 * yn/2 * x
# if n is even, yn = yn/2 * yn/2 
# if n is less than 0-negative, then change x to 1/x


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        elif n < 0:
            n *= -1
            x = 1/x
        result = self.myPow(x,n//2)
        if  n % 2 == 0:
            return result * result
        else:
            return result * result * x
            
        