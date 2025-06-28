from typing import Optional, List
import heapq

# class Solution:
#     def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
#         heap = []
#         for num in arr:
#             # push tuple of -ve distance and -index
#             heapq.heappush(heap , (-abs(num-x), -num))
#             # Maintain size k
#             if len(heap) > k:
#                 heapq.heappop(heap)
#         # Extract value and sort them 
#         res = sorted([-num for _, num in heap])
#         return res

# class Solution:
#     def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
#         l,h=0,len(arr)-1
#         while h-l+1>k:
#             distl = abs(arr[l]-x)
#             distr = abs(arr[h]-x)
#             if distl > distr:
#                 l+=1
#             else:
#                 h-=1
#         return arr[l:h+1]

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l, h = 0, len(arr) -k
        while l<h:
            mid = l+(h-l)//2
            dists = x-arr[mid]
            diste = arr[mid+k] - x
            if dists >diste:
                l= mid+1
            else:
                h=mid
        return arr[l:l+k]
        
        


        