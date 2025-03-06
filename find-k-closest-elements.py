# Max Heap with K capacity
# Time O(n log k)
# Space O(k)
from heapq import *
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        hq = []
        for num in arr: # n log k
            heappush(hq, (-abs(num-x), -num))
            if len(hq) > k: heappop(hq)
        res = []
        while len(hq) > 0:
            res.append(-heappop(hq)[1])
        res.sort() # k log k
        return res
    
# Two pointers
# Time O(n-k)
# Space O(1)    
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - 1
        while high-low + 1 > k:
            if abs(arr[low]-x) > abs(arr[high]-x):
                low += 1
            else:
                high -= 1
        return arr[low:high+1]
    
# Binary search for starting index of range
# Time O(log(n-k)) + O(k)
# Space O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k
        while low < high:
            mid = low + (high -low) // 2
            distL = x - arr[mid]
            distR = arr[mid + k] - x
            if distR >= distL: high = mid
            else: low = mid + 1
        return arr[low: low+k]