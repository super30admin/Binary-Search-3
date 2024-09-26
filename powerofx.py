class Solution(object):
    def myPow(self, x, n):
        N=n
        if N<0:
            x=1/x
            N=-N
        ans=1
        curr=x
        i=N
        while i>0:
            if i%2==1:
                ans=ans*curr
            curr=curr*curr
            i=i//2
        return ans
#Time-complexity: O(logn)
#space-complexity: O(1)