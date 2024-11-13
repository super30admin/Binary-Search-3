# time complexity: O(log n)
# space complexity: O(log n)
# Approach: Recursively calculate the power of x by dividing the power by 2 and storing the result in a variable. If the power is even, return the square of the result, else return the square of the result multiplied by x.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0:
            return 1
        if n < 0:
            x = 1 / x
            n = -n

        result = self.myPow(x, n // 2)

        if n % 2 == 0:
            return result * result
        else:
            return result * result * x


# Approach 2: Iterative solution
# time complexity: O(log n)
# space complexity: O(1)
# Approach: Iteratively calculate the power of x by dividing the power by 2 and storing the result in a variable. If the power is even, return the square of the result, else return the square of the result multiplied by x.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0:
            return 1
        if n < 0:
            x = 1 / x
            n = -n

        result = 1
        while n > 0:
            if n % 2 == 0:
                x = x * x
                n = n // 2
            else:
                result = result * x
                n = n - 1

        return result