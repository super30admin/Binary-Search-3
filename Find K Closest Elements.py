
#Binary Search to find the startingIndex of the range
""""// Time Complexity : O(log(len(arr)-k)) ~ O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        l = 0
        h = n - k

        while (l < h):
            mid = l + (h - l) // 2
            ds = x - arr[mid]
            de = arr[mid + k] - x
            if ds > de:
                l = mid + 1
            else:
                h = mid
        return arr[l:l + k]

#2-Ptr Approach
""""// Time Complexity : O(n-k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
#         l=0
#         h=len(arr)-1

#         while h-l+1>k:
#             if abs(arr[l]-x)>abs(arr[h]-x):
#                 l+=1
#             else:
#                 h-=1
#         return arr[l:h+1]


#Using Maxheap
""""// Time Complexity : O(n*log(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# import heapq

# class CustomComp:
#     def __init__(self, val, absl):
#         self.val = val
#         self.absl = absl
#
#     def __lt__(self, other):
#         if self.absl == other.absl:
#             return self.val > other.val
#         return self.absl > other.absl
#
#
# class Solution:
#     def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
#         h = []
#         count = 0
#         for i in range(len(arr)):
#             heapq.heappush(h, CustomComp(arr[i], abs(arr[i] - x)))
#             count += 1
#             if count > k:
#                 heapq.heappop(h)
#                 count -= 1
#         result = []
#         while h:
#             m = heapq.heappop(h)
#             result.append(m.val)
#         result.sort()
#         return result









