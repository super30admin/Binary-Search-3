# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        low = 0
        high = len(arr) - 1
        
        # traversing until we have the difference between low and high as k elements
        while low < (high - k + 1):
            # find the absolute difference between the element x and at that index
            distL = abs(x - arr[low])
            distH = abs(x - arr[high])
            
            # whichever dist is greater, move from that point towards the middle
            if distL >  distH:
                low += 1
            else:
                high -= 1
         # after finding the range, put the elements in the res list and return
        res = []
        for i in range(low, high+1):
            res.append(arr[i])
        return res
