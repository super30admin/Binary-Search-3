#I implemented a recursive solution to calculate the power of a number, x, raised to an integer exponent, n. The function first handles the base case where n is 0, returning 1 since any number to the power of 0 is 1. If n is negative, it adjusts x to its reciprocal (1/x) to handle negative exponents. For positive n, it recursively computes the power for half of n (i.e., abs(n)//2), squaring the result to get the power for n. If n is odd, it multiplies the result by x once more to account for the odd exponent. This approach leverages the divide-and-conquer method, reducing the problem size by half in each recursive call. The time complexity of this algorithm is O(log n) because it divides n by 2 in each step, and the space complexity is O(log n) due to the recursion stack used for the logarithmic number of calls.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
    
        if n < 0:
            x = 1/x
                
        temp = self.myPow(x, abs(n)//2)
        
        if n % 2 == 1:
            return temp * temp * x
        else:
            return temp * temp