"""
time: O(logN)
Space: O(1)
"""

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l, r = 0, len(arr) - k
        
        while l < r:
            mid = (l + r) // 2
            if (x - arr[mid] > arr[mid+k] - x):
                l = mid + 1
            else:
                r = mid
        #when l and r meet, return l:l+k range of size k
        return arr[l:l+k]