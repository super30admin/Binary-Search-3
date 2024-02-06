# Problem2 Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

import heapq

class Solution: 
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # using binary search
        low = 0
        high = len(arr) - k
        while low < high:
            mid = low + (high - low)//2
            startDist = x - arr[mid]
            endDist = arr[mid + k] - x
            if startDist > endDist:
                low = mid + 1
            else:
                high = mid
        return arr[low : low + k]

# Time complexity O(logn + k)
# Space complexity O(1)