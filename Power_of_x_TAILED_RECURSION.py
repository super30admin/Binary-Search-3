# Created by Aashish Adhikari at 6:48 PM 2/4/2021

'''
Time Complexity:
O(power)

Space Complexity:
O(1) if we do not consider the recursion stack.
'''



class Solution(object):

    def recurse(self, base, power):


        if power < 0:
            self.current_product = self.current_product * base
            self.recurse(base, power+1)

        if power > 0:
            self.current_product = self.current_product * base
            self.recurse(base, power-1)



    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """

        if x == 0:
            return 0

        self.current_product = 1 # maintaining a global variable ensures the recursion is tailed even if the language doesnt support it.
        self.recurse(x,n)

        if  n < 0:
            return 1/self.current_product

        return self.current_product