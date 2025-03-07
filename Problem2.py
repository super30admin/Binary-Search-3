# Problem 2 : Find K Closest Elements
# Time Complexity : O(log(n-k)) where n is the number of elements in the arr and k is the number of closest elements
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        # checking if array is None or length is 0 then return empty list
        if (arr == None or len(arr) == 0): 
            return result
        # set the two pointers to find the start of the range
        # set the low value to 0
        low = 0
        # set the high value to len(arr) - k. since after that position we won't be getting k elements from the array
        high = len(arr) - k 
        # loop till low is less than high
        while (low < high):
            # find the mid of the range
            mid = low + (high-low) // 2
            # consider mid as a starting point of range 
            # find the difference between arr[mid] element and x
            distLeft = x - arr[mid]
            # find the difference between x and arr[mid+k] element, since we want k elements
            distRight = arr[mid+k] - x
            # if the distLeft is greater than distRight then set the low pointer to mid+1
            if (distLeft > distRight):
                low = mid + 1
            # else set high pointer to mid
            else:
                high = mid
        # now we got the starting point of range indicated by low so store elements from low to low+k in result
        for i in range(low, low+k):
            result.append(arr[i])
        return result