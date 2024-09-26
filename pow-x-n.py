// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we do this problem using recursion.we call this recursion for every (n/2) power till we reach 1.we do this to reduce the time complexity by half.

# Time complexity --> o(n)
# space complexity --> o(n)
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n<0:
            if x!=0:
                x=(1/x)
                n=-1*n
            else:
                return 0
        if n==1:
            return x
        if n==0:
            return 1
            
        val=self.myPow(x,int(n/2))
        if n%2!=0:
            return x*val*val
        else:
            return val*val
        
        
        
        

