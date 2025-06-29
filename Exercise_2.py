# S30 Problem #88 Find K Closest Elements
#LeetCode #658 https://leetcode.com/problems/find-k-closest-elements/description/

# Author : Akaash Trivedi
# Time Complexity : O()
# Space Complexity : O()
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# Priority queue solution
# heap push and pop in O(log k) - Done for n size => O(n log k)
# sorting result list O(k log k)
# Time Complexity O(n log k + k log k)
# Space Complexity O(k) space for heap
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        maxHeap = []
        for n in arr:
            # push negative vals for max heap
            # absolute distance from x, negate for max heap so farthest element at top
            # -n: break the ties between two ele when dist is same. py compare tuples from left to right
            heapq.heappush(maxHeap, (-(abs(n-x)), -n))
            if len(maxHeap) > k:
                heapq.heappop(maxHeap)
        res = []
        for _, negN in maxHeap:
            actualVal = -negN
            res.append(actualVal)
        
        res.sort() #in place, modify directly and return none
        return res
        #return sorted(res) # return new sorted list


# Binary Search solution
# Search "the start index of the range" from 0 to n-k
# calculate the start distance from x (x -idx) and end distance [idx + k] - x (taking extra element at end)
# if distStart > distEnd then low = mid +1 else high = mid
# time complexity O(log (n-k))
# space complexity O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low = 0
        # start index of range will be between 0 to n-k
        high = n-k

        while low <  high:
            # avoid integer overflow
            mid = low + (high - low) // 2
            end = mid + k # end of the range
            # start distance
            distS = x - arr[mid]
            distE = arr[end] - x
            if distS > distE:
                # when more distance towards start then we move low
                low = mid +1
            else:
                high = mid
        res = []
        # build the res range
        for i in range(k):
            res.append(arr[low+i])
        
        return res
    
# two pointer solution
# pointers at start and end
# calculate the distance to x from each pointer and move closer to x respectively
# time complexity O(n) n -> number of elements in arr
# space complexity O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - 1

        while high - low >= k:
            distl = abs(x - arr[low])
            disth = abs(x - arr[high])
            if distl > disth:
                low += 1
            else:
                high -= 1
        res = []
        for i in range(k):
            res.append(arr[low+i]) 
        return res