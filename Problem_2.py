# time complexity - log(n - k) where k is the given numbers to find
# Space Complexity - O(k) 
# runs on leetcode : YESS
# Any Prolems : No
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low, high = 0, n-k
        while (low < high):
            mid = low+(high - low)//2
            distS = x - arr[mid]
            distL = arr[mid+k] - x
            if distS > distL: low = mid +1
            else: high = mid
        return arr[low:low+k]