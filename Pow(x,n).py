#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Jan  9 02:21:58 2020

@author: tanvirkaur
"""
#time complexity = O(logn)
#space complexity = O(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        #return x* x....n times
        #base case
        if n == 0:
            return 1
        # Logic
        temp = self.myPow(x, int(n/2))
        if n % 2 == 0:
            return temp * temp
        else:
            if n < 0:
                return temp * temp * 1/x
            else:
                return temp * temp * x

