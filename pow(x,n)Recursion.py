"""
Time Complexity : O(log n) where n is the power that needs to be raise.
                  O(log n) because calculation is done for the n/2, so reducing calulcation by half.
                  
Space Complexity : O(log n) where n is the power that needs to be raise.
                   This space is use by the recursive stack

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
In brute force way we are getting Time Limit exceeded in the cases where n is large.
To improve this we can use following approach:
1. Calculate the result for the n/2 and multiply that result with itself if n is even otherwise multiply with itself and x.
2. In case of negative x if n is odd then multiply with 1/x instead of x.
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base
        if n == 0:
            return 1
        
        #Logic
        result = self.myPow(x, int(n/2))
        
        #If number is even
        if n%2 == 0:
            return result * result
        else:
            #If number is odd check if n is positive or negative
            if n > 0:
                return result * result * x
            else:
                return result * result * (1/x)