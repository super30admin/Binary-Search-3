class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        #base
        if n == 0:
            return 1
        # when n is less than 0, convert - value back to + and change multiplied value
        if n<0:
            x = 1/x
            n = -1*n
        #logic
        
        result = self.myPow(x,n/2)
        if n%2 == 0:
            return result*result
        else:
            return result*result*x
