"""
Time Complexity : O(log(n-k)) where n is the length of the array and k is the no. given
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) == 0:
            return []
        result = []
        low = 0
        high = len(arr) - k
        # With binary search we find the leftmost bound from where I can start. We do
        # that by caluclating the lower and high bound distance and if the lower bound
        # distance is higher we increment the low pointer and if higher bound distance
        # is larger we decrement the high pointer
        while low < high:
            mid = (high + low)// 2
            distL = x - arr[mid]
            distH = arr[mid + k] - x
            if distL > distH:
                low = mid + 1
            else:
                high = mid
        for i in range(low, low + k):
            result.append(arr[i])
        return result