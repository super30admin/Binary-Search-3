# Time complexity : O(n log k)
# Space complexity : O(k)
# Leetcode : Solved and submitted

import heapq
class Solution:
    class Distance:
        def __init__(self,value,nums):
            self.value = value
            self.nums = nums
        def __lt__(self,other):
            # while comparing the elements from the Hashmao, if the differnce is same, then we take the value with lower index
            if self.nums[self.value] == self.nums[other.value]:
                return self.value > other.value
            # if not, then simply return the lower value out of both
            return self.nums[self.value] > self.nums[other.value]
        
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # hashmap to store the differnce in values and using index as the key
        nums = {}
        n = len(arr)
        
        for i in range(n):
            nums[i] = abs(arr[i] - x)
        maxHeap = []
        #fill elements in the heap using max-heap of len k
        for i in range(n):
            heapq.heappush(maxHeap, self.Distance(i,nums))
            # if we reach the size of k, then remove the top element as we are looking for k closet elements, thus they will have lowest values
            if len(maxHeap) > k:
                heapq.heappop(maxHeap)
        res = []
        # remove values from the heap and store in res list
        while maxHeap:
            temp = heapq.heappop(maxHeap).value
            res.append(arr[temp])
        # sort the list as it will take k log k
        res.sort()
        return res
