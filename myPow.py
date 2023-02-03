# Time Complexity :O(log(n))
# Space Complexity :O(log(n))
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


class Solution(object):
    def myPow(self, x, n):
        def rec(x,n):
            if(x==0):return 0
            if(n==0):return 1

            result=rec(x*x,n//2)
            return(result*x) if n%2 else result
        
        k=rec(x,abs(n))

        return(k) if n>0 else 1/k