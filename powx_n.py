class Solution:
    def myPow(self, x: float, n: int) -> float:
        # recursive approach
        if n < 0:
            x = 1 / x
            n = -n

        # Base case
        if n == 0:
            return 1

        # Recursive case
        result = self.myPow(x, n // 2)

        # If n is even
        if n % 2 == 0:
            return result * result
        # If n is odd
        else:
            return result * result * x


# #time complexity is O(log n)
# #space complexity is O(log n)


# iterative approach


class Solution:
    def myPow(self, x: float, n: int) -> float:

        if n < 0:
            x = 1 / x
            n = -n

        result = 1
        current_product = x

        while n > 0:

            if n % 2 == 1:
                result *= current_product

            current_product *= current_product

            n //= 2

        return result


# #time complexity is O(log n)
# #space complexity is O(1)
