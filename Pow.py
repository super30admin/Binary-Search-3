# TC - O(log n)
# SC - O(log n)
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """

        def pow_x(x, n):
            if n == 0:
                return 1.0
            else:
                pow_of_x = pow_x(x, n/2)
                pow_of_x = pow_of_x * pow_of_x
                if n % 2 != 0:
                    return pow_of_x * x
                return pow_of_x

        if n < 0:
            return pow_x(1/x, abs(n))
        else:
            return pow_x(x, n)
