#Time Complexity: O(logn) as we are diving n by half for every iteration
#Space complexity: O(logn) recursion stack

# The intuition is to half everytime and multiple x to the result if the n is odd.

class Solution:
    def myPowRecursion(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n < 0:
            x = 1 / x
            n = -n
        result = self.myPowRecursion(x, n//2)
        if n % 2 == 0:
            return result * result
        else:
            return result * result * x

    # Time complexity : O(logn) same logic as recursion
    # Space complexity: O(1) since we are not using any extra space.
    def myPow(self, x: float, n: int) -> float:
        result = 1.0
        if (n < 0):
            x = 1/x
            n = -n
        while(n != 0):
            if n%2 == 1:
                result = x * result

            x = x * x
            n = n//2
        return result
