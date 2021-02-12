# Created by Aashish Adhikari at 6:59 PM 2/4/2021

'''
Time Complexity:
O(log(power))

Space Complexity:
O(log(power))
'''

class Solution(object):

    def recurse(self, base, power):

        # base case
        if power == 0:
            return 1

        if power%2 == 0:
            half = self.recurse(base,power/2)
            return half * half
        else:
            half  = self.recurse(base, (power-1)/2)
            return half * half * base





    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """

        if n < 0:
            return 1/self.recurse(x, -n)
        else:
            return self.recurse(x,n)
