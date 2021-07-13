# Time Complexity: O(logn)
# Space Complexity: O(logn)
class Solution:
    def myPow(self, x, n):
        #         if n ==0 we will return 1
        if n == 0:
            return 1.00
        #         we will recursively call same function for nas half of n
        res = self.myPow(x, int(n / 2))

        #         if n is even we wil return
        if n % 2 == 0:
            return res * res
        #         if n is less than 0
        elif n < 0:
            return res * res * (1 / x)
        else:
            return res * res * x
