## Problem2 
# Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        if arr==None or len(arr)==0:
            return result
        low = 0
        high = len(arr)-1
        while high - low +1 > k:
            if abs(arr[low]-x)>abs(arr[high]-x):
                low = low+1
            else:
                high = high - 1
        for i in range(low,high+1):
            result.append(arr[i])
        return result
        