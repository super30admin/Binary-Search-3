# problem - 50 - POW(X,N) - https://leetcode.com/problems/powx-n/
# recursive approach 
# Time complexity - log(N) 


class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        
        """
        if n==0:
            return 1
        if n>0:
            temp=self.myPow(x,n/2)
            if n%2==0:
                return temp*temp
            else:
                return temp*temp*x
        else:
            return 1/self.myPow(x,-n)





class Solution(object):
    def myPow(self, x, n):
        if not n:
            return 1
        if n < 0:
            return 1 / self.myPow(x, -n)
        if n % 2:
            return x * self.myPow(x, n-1)
        return self.myPow(x*x, n/2)