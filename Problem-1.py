class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n > 0:
            return self.helper(x, n)
        elif n == 0:
            return 1
        else:
            return self.helper(1/x, -n)

    def helper(self, x, n):
        # base case
        if n == 1:
            return x

        # logic
        carry = 1
        if n % 2 == 0:
            result = self.helper(x, n//2)
        else:
            carry = x
            result = self.helper(x, (n-1)//2)

        result = result * result * carry

        return result