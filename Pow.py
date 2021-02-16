# TC: O(Logn)
# SC: O(1)
# Yes, It ran on leetcode
# No problems faced

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        def helper(x,n):
            if n==1:
                return 2
            mid = helper(x,n//2)
            if n%2==0:
                return mid*mid
            else:
                return mid*mid*2
            
        if n<0:
            return 1/helper(x,n)
        else:
            return helper(x,n)