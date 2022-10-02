"""
Time Complexity : O(nlogk) + O(k) where n is the total number of elements in the array and  
                  k is the kth number of elements that needs to be return.
                  nlogk is the time required for heapify. heapify will take place for k elements but we will do it on all n elements.
Space Complexity : O(logk) Space taken by heap

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We can use the heap here as we need to return the K Closest element.
1. Consider heapify will take place on the basis of difference between the element and x and then number itself.
   number itself as if the difference between element and x for two array elements is same then we need to return the element which is smaller.
2. Use the max heap as top of the heap will have elements with maximum difference and 
   if the heap length exceeds K then we can pop the elements which are not closest to x
"""
import heapq
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) == 0:
            return []
        heap = []
        result = []
        for i in range(len(arr)):
            heapq.heappush(heap, (abs(x-arr[i])*-1, arr[i]*-1, arr))
            
            if len(heap) > k:
                heapq.heappop(heap)
        
        for i in range(len(heap)):
            diff, val, arr = heapq.heappop(heap)
            result.append(val*-1)
        
        return sorted(result)