"""
Approach: 2ptr
"""
from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result=[]
        if arr==None or len(arr)==0:
            return result

        low=0
        high=len(arr)-1
        while (high-low +1 >k): #since high and low are indices and k is num
            distance_low=x-arr[low]
            distance_high=arr[high]-x

            if distance_low>distance_high:
                low+=1
            else:
                high-=1


        for i in range(low,high+1):
            result.append(arr[i])

        return result

s=Solution()
print(s.findClosestElements([1,2,3,4,5],4,3))