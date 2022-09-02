#Recursive Approach
#Time complexity: O(logn)
#Space complexity: O(logn)
#Worked in Leetcode: Test cases passed bit didn't work when submitted          #Error: Maximum recursion depth excedded when comparison
#Issue is with
# 2.00000
# -2

#Any issues while working on it: No

class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base
        if n == 0:
            return 1.00
        #logic
        result = self.myPow(x, n//2)
        
        if (n%2 == 0):
            return result*result
        else:
            if (n > 0):
                return result*result*x
            else:
                return result*result*(1/x)
            
            
#Iterative Approach
#Time complexity: O(logn)
#Space complexity: O(1)
#Worked in Leetcode: Yes
#No issues

class Solution:
    def myPow(self, x, n):
        if n < 0:
            x = 1 / x
            n = -n
        a = 1
        while n:
            if n & 1:
                a *= x
            x *= x
            n >>= 1
        return a
