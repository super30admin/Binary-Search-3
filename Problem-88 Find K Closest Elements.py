# 658. Find K Closest Elements
# https://leetcode.com/problems/find-k-closest-elements/

# Logic: We are trying to find the left most boundry for the given x. 
# We know that at max the boundry can lie at len(arr) - k. We do binary 
# search to find the left boundry. Out of mid and mid+k only one element 
# can be taken in the result. So we check their distance from x and move 
# the left and right pointer accordingly.

# Time Complexity: O(logn)
# Space Complexity: O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if k == len(arr):
            return arr
        
        left = 0
        right = len(arr) - k
        
        while left < right:
            mid = left + (right-left)//2
            
            if x - arr[mid] <= arr[mid + k] - x:
                right = mid
            else:
                left = mid + 1
        
        return arr[left:left+k]
