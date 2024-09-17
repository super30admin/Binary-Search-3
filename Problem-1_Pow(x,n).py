# APPROACH 1: BRUTE FORCE
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No (TIME LIMIT EXCEEDED)
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Simply keep multiplying x n times and return the end product
# 2. If n < 0, return 1 / end product.

class Solution:
    
    def myPow(self, x: float, n: int) -> float:
        
        result, flag = 1, False
        
        if n < 0:
            n = -1 * n
            flag = True
            
        while n > 0:
            result *= x
            n -= 1
        
        if flag:
            return 1 / result
        else:
            return result
        



# APPROACH 2: BINARY DIVISION
# Time Complexity : O(lg n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. If n < 0, call helper with positive n and return the result as 1 / result, for other cases as result
# 2. helper is a recusive function. Each time call the function with half the power -> temp
# 3. If n is even -> temp * temp and if n is odd -> temp * temp * x

class Solution:
    
    def myPow(self, x: float, n: int) -> float:
        
        if n < 0:
            return 1 / self.helper(x, -1 * n)
        else:
            return self.helper(x, n)
            
            
    def helper(self, x, n):
        if n == 0: 
            return 1
        
        temp = self.helper(x, n // 2)
        
        if n % 2 == 0:
            return temp * temp
        
        else:
            return temp * temp * x
