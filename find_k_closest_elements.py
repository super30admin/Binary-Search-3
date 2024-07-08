# Time Complexity : O(log(n-k))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr)-k

        while low < high:
            mid = int(low +(high-low)/2)
            distS = x - arr[mid]
            distE = arr[mid+k] - x
            if distS > distE:
                low = mid+1
            else:
                high = mid
        
        result = []
        for i in range(low, low+k):
            result.append(arr[i])
        
        return result
