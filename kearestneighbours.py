# -*- coding: utf-8 -*-
"""
TC : O(log(N+k)) where N is the size of the list given and k is the no. of elements we have to return
SC : O(1) as no extra space used
"""

class Solution:
    def findClosestElements(self, arr: [int], k: int, x: int):
        
        #edge case
        if not arr or len(arr) ==0:return []
        #If length of array is less than k, return nothing
        if len(arr)<k:
            return
        #If length of array is equal to k, return the array
        if len(arr)==k:
            return arr
    
        #If x is less than the smallest element, return first k elements
        if x <= arr[0]: return arr[:k]
    
        #If x is greater than the largest element, return last k elements
        if x >= arr[-1]: return arr[-k:]
    
    
        l=0
        r=len(arr)-k
    
        #Finding of the first element of k elements using Binary Search
        while l<r:
            mid=(l+r)//2
            if x - arr[mid] > arr[mid+k] - x:
                l = mid + 1
            else:
                r = mid    
        return arr[l:l+k]

S = Solution()
print(S.findClosestElements([],3,2))