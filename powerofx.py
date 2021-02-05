# -*- coding: utf-8 -*-
"""
TC : O(logN) where N is the exponent
SC : recursive stack space used 
"""
class Solution:
    def myPow(self, x: float, n: int):
        #edge case
        if n == 0 or x == 1: return 1
        if n == 1: return x
        
        if n < 0:
            return self.myPow(1/x,-n)
        
        #case when n is even
        if n % 2 == 0:
            return self.myPow(x*x,n//2)
        else:
            #case when n is odd
            return x*self.myPow(x*x,n//2) 
            