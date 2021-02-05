#Time Complexity :O(logn) 
#Space Complexity :o(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if(n<0):
            #negative power
            ans=self.power(x,-n)
            return 1/ans
        else:
            ans=self.power(x,n)
            return ans
    
    def power(self,x,n):
        #base
        if(n==0):
            return 1
        #logic
        temp=self.power(x,n//2)
        if(n%2==0):
            return temp*temp
        else:
            return temp*temp*x
        