# Time complexity : O(log (n - k))
# Space complexity : O(1)
# Leetcode : Solved and submitted
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        
        # put the boundaries, low as 0 and high as n - k as we are looking for the starting index of the range
        low = 0
        high = n - k
        
        # going over the list until low and high doesn't cross each other
        while low < high:
          # find mid
            mid = low + (high - low) // 2
          # calculate the distance from mid and decide which way to go
          # distL is the distance from x from this element and distR is (mid + k)th element
          # we do this in order to check for element which could have a smaller dist with x
            distL = x - arr[mid]
            distR = arr[mid + k] - x
            
            # whichever dist is greater, we move closer from that side towards the other end
            if distL > distR:
                low = mid + 1
            else:
                high = mid
         # after finding the starting index, we simply put the elements from starting index, k elements into res and return it
        res = []
        for i in range(low, low + k):
            res.append(arr[i])
            
        return res
