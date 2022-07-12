

# // Time Complexity :O(logn) each time n/2
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



import math
class Solution:
    def myPow(self, x, n) :
        #base
        if n==0:
            return 1.00
        #logic
        a=abs(n)//2
        if n<0:
            result=self.myPow(x,-a)
        else:
            result=self.myPow(x,a)
        print(result)
        if(n%2==0):
            return result*result
        else:
            if n>0:
                return result*result*x
            else:
                return result*result*(1/x)