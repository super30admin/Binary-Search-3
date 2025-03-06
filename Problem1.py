class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1  # Base case: Anything raised to 0 is 1

        # Recursive call
        
        if n < 0:
            x = 1/x
            n = -n

        result = 1
        while n:
            if n%2 != 0:
                result *= x
            x *= x
            n = n//2
        return result