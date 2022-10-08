#Time: O(logn)
#Space: O(logn)
#Problem ran on leetcode without any issues

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1.0 
        
        result = self.myPow(x, int(n/2))
        if (n%2 == 0):
            return result * result
        else:
            if n > 0: 
                return result * result * x
            else:
                return result * result * 1/x