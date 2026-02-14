#--------------- Solution 1 : Brute Force : calculate the distance and sort ------------
''' Time Complexity : O(nlogn) ; 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l = []
        result = []
        for n in arr:
            l.append((abs(n - x),n))
        l.sort()
        for i in range(k):
            result.append(l[i][1])
        result.sort()
        return result

#--------------- Solution 2 : Using MaxHeap  ------------
''' Time Complexity : O(nlogk) ; 
    Space Complexity : O(k) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
import heapq
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = []
        n = len(arr)
        for i in range(n):
            dist = abs(arr[i]-x)
            heapq.heappush(heap, (-dist, -arr[i]))
            if len(heap) > k:
                heapq.heappop(heap)

        result = []
        result = [-item[1] for item in heap]
        result.sort()
        return result

#--------------- Solution 3 : Two pointer - inward till len is not K  ------------
''' Time Complexity : O(n) ; 
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l = 0
        r = len(arr) - 1
        while (r - l) >= k:
            if abs(arr[l] - x) <= abs(arr[r] - x):
                r -= 1
            else :
                l += 1
        return arr[l:r+1]