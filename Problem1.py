"""
// Time Complexity : o(n/2)
// Space Complexity : o(n/2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0: 
            return 1
        
        temp = self.myPow(x,int(n/2)) #idea is to half the power each time and multiply the result twice
        
        if n % 2 == 0: #if n is even, multiply the two halves
            
            return temp * temp 
        else: #if odd, multiply the number itself too
            if n < 0:
                return temp * temp * (1/x)
            else:
                return temp * temp * x
            
    