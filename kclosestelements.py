"""
Given a sorted integer array arr, two integers k and x, 
return the k closest integers to x in the array. 
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        low = 0
        high = len(arr)-1
        result = []
        
        
        while high-low+1 > k:
            
            if abs(arr[low] - x) > abs(arr[high] - x):
                low += 1
            else:
                high -= 1
                
        for i in range(low, high+1):
            result.append(arr[i])
            
        return result

       