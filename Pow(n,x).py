# // Time Complexity :O(nlogk)
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class solution:
    def pow( self, x, n):
        res = self.helper(x,abs(n))
        return res if n>0 else 1/res

    def helper(self, x , n):
        ##base
        if n <= 0:
            return 1
        
        ##logic
        num = self.helper(x*x, n//2)

        if n %2 == 1:
            return num *x
        else:
            return num

    def iterative(x,n):
        if n <0:
            x = 1/x
            n = abs(n)
        
        res = 1
        while n:
            if n%2 == 1:
                res = res*x
            x = x*x
            n = n//2
        
        return res
