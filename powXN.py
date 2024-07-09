# Time Complexity : O(logn), as the function repeatedly divides n by 2
# Space Complexity : O(logn), due to recrsion stack space

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n < 0:
            x = 1 / x
            n = -n
        result = self.myPow(x, n // 2)
        if n % 2 == 0:
            return result * result
        else:
            return result * result * x

# Examples
solution = Solution()

# Example 1
x1, n1 = 2.0, 10
print("myPow({}, {}) = {}".format(x1, n1, solution.myPow(x1, n1)))  # Expected output: 1024.0

# Example 2
x2, n2 = 2.1, 3
print("myPow({}, {}) = {}".format(x2, n2, solution.myPow(x2, n2)))  # Expected output: 9.261

# Example 3
x3, n3 = 2.0, -2
print("myPow({}, {}) = {}".format(x3, n3, solution.myPow(x3, n3)))  # Expected output: 0.25