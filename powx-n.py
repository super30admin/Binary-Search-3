# Brute Force [Time Limit Exceeded]
class Solution:
    def myPow(self, x: float, n: int) -> float:
        output = 1
        if n > 0:
            for i in range(n):
                output = output * x
        else:
            for i in range(abs(n)):
                output = output * (1/x)
        return output



# Bottom up recursion
# Time Complexity: O(log n)
# Space Complexity: O(log n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Base
        if n == 0:
            return 1
        # Logic
        result = self.myPow(x, int(n/2))
        # If n is even, just multiply the halves 
        if n % 2 == 0:
            return result * result
        # If n is odd, check if n is greater than 0 
        # If n is greater than 0, multiply result * result with x additionally since one x is extra
        # If n is less than 0, divide result * result with x 
        else:
            if n > 0:
                return result * result * x
            else:
                return result * result * (1/x)