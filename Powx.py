#Time:O(logn)
#Space:O(logn)
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if x==0:
            return 0
        if abs(x) < 1e-4: return 0
        if n == 0:
            return 1
        if n < 0:
            x = 1 / x
            n = -n
        ans = self.myPow( x, n//2)
        if n%2:
            return ans*ans*x
        else:
            return ans*ans