'''
Problem2

Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)
'''

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]: # type: ignore
        result = []
        n = len(arr)
        left = 0
        right = n-1

        while right - left + 1 > k:
            distL = x - arr[left]
            distR = arr[right] - x
            if distL > distR:
                left = left + 1
            else:
                right = right - 1

        return arr[left : left + k]          