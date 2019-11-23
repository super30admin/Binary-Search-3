

#passed in leetcode
#Time - O(log n)
#space - O(1)

class Solution(object):
    def myPow(self, x, n):
        # Base Case
        if n == 0:
            return 1
        if n % 2 == 0:
            return pow(self.myPow(x, n//2),2)
        else:
            if n > 0: #power odd
                return pow(self.myPow(x, n//2),2)*x
            else: # negative power
                return pow(self.myPow(x, n//2),2)*(1/x)

#did not pass in leetcode -- Max recursion depth error
class Solution(object):
    def myPow(self, x, n):
        if n < 0:
            return 1 / self.myPowRecur(x, n)
        return self.myPowRecur(x, n)

    def myPowRecur(self, x, n):
        # Base case.
        if n == 0:
            return 1

        if n % 2 == 0:
            return self.myPowRecur(x * x, int(n / 2))
        else:  # case when  n is odd
            return x * self.myPowRecur(x * x, int(n / 2))