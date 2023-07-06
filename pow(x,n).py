# // Time Complexity :O(log(n))
# // Space Complexity :O(log(n))
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def myPow(self, x: float, n: int) -> float:
        def function (b=x,e=abs(n)):
            if(e==0):
                return 1
            elif(e%2==0):
                return function(b*b,e//2)
            else:
                return b*function(b*b,(e-1)//2)
        f = function()
        return float(f) if n >= 0 else 1/f
            
