"Time Complexity is O(log N)"
"Space Complexity is O(1)"

#Explanation1. 
"If `n` is negative, compute `1 / myPow(x, -n)` to handle negative exponents.  
"Recursively compute `half = myPow(x, n // 2)` to reduce the problem size by half.  
"If `n` is even, return `half * half`; if `n` is odd, return `half * half * x`.  
"Repeat until `n` becomes 0, then return 1 as the base case result.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        
        if n < 0:
            return 1 / self.myPow(x, -n)
        
        half = self.myPow(x, n//2)

        if n % 2 == 0:
            return half * half
        else:
            return half * half * x
        
