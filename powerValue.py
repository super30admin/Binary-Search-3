'''
Time Complexity --> O(logn)
Space Complexity --> O(1)
'''
class Solution:
    # @param {float} x
    # @param {integer} n
    # @return {float}
    def myPow(self, x, n):
        if n < 0:
            return 1 / self.Pow(x, -n)
        else:
            return self.Pow(x, n)

    def Pow(self, x, n):
        if n == 0:
            return 1

        temp = self.Pow(x, n// 2)
        if n % 2 == 0:
            return temp * temp
        else:
            return temp * temp * x