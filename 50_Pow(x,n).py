# Leetcode problem link : https://leetcode.com/problems/powx-n/
# Time Complexity:    O(n/2) for the recursive calls till n//2
# Space Complexity:   O(n/2) recursive stack
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    Once square root is calculated it can be utilised to multiply and get square. Hence x^n = x^n/2 * x^n/2 for even n and multiply by another x for odd. 
    If n is negative, change x to 1/x instead and make n positive

'''  
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            x = 1/x
            n = -n
        sqrt = self.myPow(x,n//2)
        if n % 2 == 0:
            return sqrt * sqrt
        else:
            return sqrt * sqrt * x