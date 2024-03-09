'''
TC: O(nlogk)+O(klogk) ~ O(n+k)logk 
        where n is the total number of elements in array
        and k is the capacity of the heap and to sort for the answer 
            in the final step
SC: O(k) where k is the heap capacity
'''
import heapq
from typing import List

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #Heaps - need minimum value so use maxHeap
        heap = []
        counter = 0
        for i,v in enumerate(arr):
            heapq.heappush(heap, (-abs(v-x), -v))
            if len(heap)>k:
                heapq.heappop(heap)
        res = []
        while heap:
            res.append(-heapq.heappop(heap)[1])
        res.sort()
        return res
s = Solution()
print(s.findClosestElements([1,2,3,4,5], 4, 3))
print(s.findClosestElements([1,2,3,4,5], 4, -1))
print(s.findClosestElements([1,2,3,3,4,5], 4, 3))