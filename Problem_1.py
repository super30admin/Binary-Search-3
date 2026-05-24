# class Solution:
#     def myPow(self, x, n):
#         if n == 0:
#             return 1.0
#         if n < 0:
#             return 1.0 / self.myPow(x, -n)
#         if n % 2 != 0:
#             return x * self.myPow(x * x, (n - 1) / 2)
#         return self.myPow(x * x, n / 2)

class Solution:
    def myPow(self, x,n):
        result = 1.0
        if n < 0:
            x = 1.0 / x
            n = n * -1

        while n != 0:
            if n % 2 != 0:
                result *= x
            x = x * x
            n = n // 2

        return result

             
    