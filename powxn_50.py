# // Time Complexity : O(log n)
# // Space Complexity : O(log n +c)  where c is recursive stack constant space
# // Did this code successfully run on Leetcode : Yes 
# // Any problem you faced while coding this : No

# Your approach:

# Brute Force: multiply x with itself n times, in O(n) time

# Optimized(coded below):
# When n is even: it can be broken down into x^(n/2) * x^(n/2) eg: 2^10: 2^5 * 2^5
# when n is odd: it can be broken down into x^(n/2) * x^(n/2) * x eg: 2^5: 2^2 * 2^2 * 2
# Use recursion to calculate this. If n is negative: reciprocate the answer.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0:
            return 1
        
        recurVal = (self.myPow(x, abs(n)//2))
        
        if n%2 == 0:
            output = recurVal * recurVal
        else:
            output = recurVal*recurVal*x
            
        #if n is negative, reciprocate
        if n<0:
            return 1/output
        
        return output
            
        
    
    
    
        