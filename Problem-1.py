# Time Complexity : O(log n), because each recursive call reduces n by half
# Space Complexity : O(log n), due to recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# We implement power function (x^n) using **fast exponentiation / divide and conquer**:
# 1. If n == 0, return 1 (base case)
# 2. If n < 0, convert it to positive and invert x (x^-n = (1/x)^n)
# 3. Recursively compute power:
#    - If n is even: pow(n) = pow(n/2) * pow(n/2)
#    - If n is odd: pow(n) = x * pow(n-1)
# This reduces the number of multiplications from O(n) to O(log n)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            # Base case: any number to the power 0 is 1
            return 1
        
        if n < 0:
            # Handle negative powers by inverting x
            n = -n
            x = 1 / x
        
        def pow(n):
            # Recursive helper function
            if n == 1:
                return x  # Base case: power of 1
            if n % 2 == 0:
                # Even n: compute half power and multiply
                half = pow(n // 2)
                return half * half
            else:
                # Odd n: reduce to even by multiplying x once
                return x * pow(n - 1)
        
        return pow(n)

# Example usage:
# obj = Solution()
# print(obj.myPow(2.0, 10))  # Output: 1024.0
# print(obj.myPow(2.0, -2))  # Output: 0.25