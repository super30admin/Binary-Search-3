# // Time Complexity : O(lg n) where n is the power
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0: return 1
        
        if n % 2 == 0: 
            res = self.myPow(x,n//2)
            return res*res
        else:
            if n > 0:
                res = self.myPow(x,n//2)
                return res*res*x
            else:
                res = self.myPow(x,(-n)//2)
                return 1/(res*res*x)

        