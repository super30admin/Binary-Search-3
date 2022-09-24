# Time Complexity : O(n log k) + O(k) where n length of the array and k is number closest elements to findout
# Space Complexity : O(k) k is number closest elements to findout
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq

class Num:
    def __init__(self, num, diff):
        self.num = num
        self.diff = diff
        
    def __lt__(self, other):
        if self.diff != other.diff:
            return self.diff > other.diff
        return self.num > other.num
        
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = []
        heapq.heapify(heap)
        for n in arr:
            heapq.heappush(heap, Num(n, abs(x-n)))
            if len(heap) > k:
                heapq.heappop(heap)
            
        return sorted([n.num for n in heap])