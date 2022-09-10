#  658. Find K Closest Elements
'''
Leetcode all test cases passed: Yes
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
    n is length of arr
      Time Complexity: O(log n + k)
      Space Complexity: O(1)
'''
from bisect import bisect_left
from collections import deque
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        index = bisect_left(arr,x)        
        res = deque()
        l,r = index-1,index
        while l >= 0 and r < len(arr):
            if len(res) == k:
                return res
            if (abs(x - arr[l]) <= abs(x - arr[r])):
                res.appendleft(arr[l])
                l -= 1
            else:
                res.append(arr[r])
                r += 1
        while r < len(arr) and len(res) < k:
            res.append(arr[r])
            r += 1
        while l >= 0 and len(res) < k:
            res.appendleft(arr[l])
            l -= 1
        return res
