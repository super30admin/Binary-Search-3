#pow(x,n)
#time complexity: O(logN) where n is the 
#space complexity: O(logN)
class Solution:
    def myPow(self, x, n):
        if n < 0:
            return 1 / self.pow(x, -n)
        else:
            return self.pow(x, n)

    def pow(self, x, n):
        if n == 0:
            return 1

        temp = self.pow(x, n // 2)
        if n % 2 == 0:
            return temp * temp
        else:
            return temp * temp * x