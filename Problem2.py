## Problem2 
# Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

# Approach
# using 2 pointer, set low = 0 and high = len(arr)-1. While high - low+1 > k, calculate abs dist between arr[low] and x and arr[high] and x
# if distL > distH, low += 1 else high -= 1. This will also fulfill the 2nd condition if dist is same, it will decrement high and keep low in the range
# Traverse the arr from low to high, append elements in res list. return res

# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res = []
        low = 0
        high = len(arr)-1

        while(high - low+1 > k):
       
            distL = abs(x- arr[low])
            distH = abs(x- arr[high])

            if distL > distH:
                low += 1
            else:
                high -= 1
        
        for i in range(low, high+1):
            res.append(arr[i])
        
        return res