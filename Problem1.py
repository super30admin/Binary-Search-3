## Problem1 
# Pow(x,n) (https://leetcode.com/problems/powx-n/)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        """
        Time Complexity: O(log n)
        - We are dividing the exponent 'n' by 2 at each recursive step.
        - Therefore, the number of recursive calls is proportional to the base-2 logarithm of n.
        
        Space Complexity: O(log n)
        - The recursive calls are added to the call stack.
        - The maximum depth of the recursion tree is log n, which dictates the auxiliary space used.
        """
        def power(x: float, n: int) -> float:
            # Base case: Any number to the power of 0 is 1.0
            if n == 0:
                return 1.0

            # Logic: Divide and Conquer (Exponentiation by Squaring)
            # Recursively calculate the result for half of the current power (n // 2)
            res = power(x, n // 2)
            
            # If the current power 'n' is odd, square the half-result and multiply by x one extra time
            if n % 2 != 0:
                res = res * res * x
            # If the current power 'n' is even, simply square the half-result
            else:
                res = res * res
                
            return res

        # Handle negative exponents: x^-n is equivalent to (1/x)^n
        if n < 0:
            x = 1 / x
            n = -n

        # Execute the recursive helper function with the adjusted x and n
        return power(x, n)