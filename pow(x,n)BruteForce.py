"""
Time Complexity : O(n) where n is the power that needs to be raised. 
                  O(n) as we will iterate n times to multiply x with itself
Space Complexity : O(1) as no auxillary data structure is ude

Did this code successfully run on Leetcode : No Time Limit Exceeded
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Brute force way is to multiply x n times and return the result.
If number is negative then calculate the result and return its reciprocal
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        result = 1
        for i in range(abs(n)):
            result = result * x
        if n < 0:
            return 1 / result
        return result
        
        