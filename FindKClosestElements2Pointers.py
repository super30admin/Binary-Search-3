'''
TC: O(n) - n is the number of elements in the array
SC: O(1) - we are only dealing with 2 pointers and storing it in result 
'''
from typing import List

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #2 Pointers
        i,j = 0, len(arr)-1
        while i<=j:
            if i+k-1==j:
                break
            if abs(arr[i]-x)<=abs(arr[j]-x):
                j-=1
            else:
                i+=1
        res = []
        for it in range(i,j+1):
            res.append(arr[it])
        return res
s = Solution()
print(s.findClosestElements([1,2,3,4,5], 4, 3))
print(s.findClosestElements([1,2,3,4,5], 4, -1))
print(s.findClosestElements([1,2,3,3,4,5], 4, 3))
print(s.findClosestElements([1,5,6,8,10,14,15,20], 3, 10))