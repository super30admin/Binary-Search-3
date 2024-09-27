#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Jan  9 02:22:27 2020

@author: tanvirkaur
"""

#time complexity = O(k+logn)
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
        if not arr:
            return result
        low = 0
        high = len(arr)-k
        while low < high:
            mid = (low + high)//2
            diffL = abs(arr[mid]-x)
            diffR = abs(arr[mid+k]-x)
            if diffL > diffR:
                low = mid+1
            else:
                high = mid
        for i in range(low,low+k):
            result.append(arr[i])
        return result 