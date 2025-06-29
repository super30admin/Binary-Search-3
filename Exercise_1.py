# S30 Problem #87 POW(x,n) x raised to the power n
#LeetCode #50 https://leetcode.com/problems/powx-n/

# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

#Approach:
# reduce n by half each time 
# double x each time and calculate the value, and use it in next calculation
# if even then just double, if odd then double and multiple by x

#recursive
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0:
            return 1.0
        #logic
        # if negative we have to make x to 1/x and n positive
        if n < 0:
            x = 1/x
            n = n * -1
        # recursively call and make n half
        res = self.myPow(x, n//2)
        # as we make n half, we square/double the result
        if n % 2 == 0:
            return res * res
        else:
            # if odd then we multiple by x, to count for odd power
            return res * res * x

# iterative
class Solution:
    def myPow(self, x: float, n: int) -> float:
        re = 1
        # for negative powers
        if n < 0:
            n *= -1 
            # do 1/x
            x = 1.0/x
        
        while n != 0:
            # when n is odd we mutiply by x 
            # reduce n by 1 (taken care by floor division)
            if n % 2 != 0:
                re = re * x
                #n = n - 1
            # square x and reduce n by half floor division
            
            x = x * x
            n = n//2
        return re