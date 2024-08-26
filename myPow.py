class Solution:
    """
    Time Complexity: O(log N)
    Space Complexity: O(log N)
    """
    def myPow(self, x: float, n: int) -> float:
        # Base case: anything raised to the power of 0 is 1
        if n == 0:
            return 1
        
        # Handle negative exponent
        if n < 0:
            x = 1 / x
            n = -n
        
        # Recursive case
        half = self.myPow(x, n // 2)
        
        # If n is even, the result is half * half
        if n % 2 == 0:
            return half * half
        # If n is odd, multiply one more time by x
        else:
            return half * half * x
