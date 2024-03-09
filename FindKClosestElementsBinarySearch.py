'''
TC: O(log(n-k))+O(k) where n-k if the range we are working with here!
    and k is the range needed to find the number of elements from the 
    starting point
SC: O(1) - Not using any space that the output.
'''
from typing import List

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #Binary Search
        i,j = 0,len(arr)-k
        while i<j:
            mid = (i+j)//2
            s = x-arr[mid]
            e = arr[mid+k-1]-x
            if s<=e:
                j=mid
            else:
                i=mid+1
        res = []
        for it in range(i,i+k):
            res.append(arr[it])
        return res
s = Solution()
print(s.findClosestElements([1,2,3,4,5], 4, 3))
print(s.findClosestElements([1,2,3,4,5], 4, -1))
print(s.findClosestElements([1,2,3,3,4,5], 4, 3))