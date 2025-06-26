# Time Complexity: O(log(n-k)+k) where n is the number of elements in array and k is the range
# Space Complexity: O(k) where k is the range
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k
        while low < high:
            m = (low+high)//2
            if x - arr[m]>arr[m+k] - x:
                low = m+1
            else:
                high = m
        return arr[low:low+k]