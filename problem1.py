#POW
# // Time Complexity :  O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def myPow(self, x: float, n: int) -> float: 
        
    def helper(x, n):
        if x==0:
            return 0
        if n == 0: 
            return 1
        res = helper(x, n//2)
        if n % 2 == 0: 
            return res*res
        if n % 2 == 1: 
            return res*res*x
    res = helper(x, abs(n))
    return res if n>0 else 1/res