#------Solution 1 : Brute Force -------
''' Time Complexity : O(n) ; Time Limit Exceed
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        result = 1
        if n < 0:
            x = 1/x
            n *= -1
        for i in range(n):
            result = result * x

        return result


#------Solution 2 : Recursive method -------
''' Time Complexity : O(log n) ; 
    Space Complexity : O(log n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def myPow(self, x: float, n: int) -> float: 
        def helper(x,n):
            if n == 0:
                return 1
            
            re = helper(x, n//2)
            
            if n % 2 == 0:
                return re * re
            else:
                return re * re * x
        if n < 0:
            x = 1 / x
            n = -n

        return helper(x,n)

        