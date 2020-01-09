#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Jan  9 02:24:21 2020

@author: tanvirkaur
"""
#time complexity = O(n)
#space complexity = O(1)
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        result = []
        #base case
        if not arr:
            return result
        low = 0
        high = len(arr)-1
        while high-low+1 > k:
            diffL = abs(arr[low]-x)
            diffR = abs(arr[high]-x)
            if diffL > diffR:
                low += 1
            else:
                high -= 1
        for i in range(low,high+1):
            result.append(arr[i])
        return result
            