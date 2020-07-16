# Time Complexity : O(log n-k) [n = len of the input list, k = input given]
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. The pattern of the problem is **finding the range**
# 2. The low or start index lies between the range [0, len(arr)-k]
# 3. We perform a binary serach to look for correct position of low
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) == 0 or k ==0 :return []
        
        low = 0 
        high = len(arr)-k
        
        while low < high:
            mid  = low + (high-low)//2
            if x - arr[mid] > arr[mid+k] - x:
                low = mid+1
            else:
                high = mid
        return arr[low:low+k]