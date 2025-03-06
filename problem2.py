'''
// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = []

        for i, num in enumerate(arr):
            dist = abs(num - x)
            heapq.heappush(heap, (dist, num))
        res = []
        for i in range(k):
            dist, num = heapq.heappop(heap)
            res.append(num)
        res.sort()
        return res
