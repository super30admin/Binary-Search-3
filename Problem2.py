"""
Implemented using the technique discussed in the session, where I used binary search to find the optimal starting index of the subarray.
At each step, I compare distances from both ends of the window to move the window closer to x.
Time Complexity: O(log (n - k) + k)
Space Compelxity: O(1)
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k
        while low < high:
            mid = (low + high) // 2
            end = mid + k
            dists = x - arr[mid]
            diste = arr[end] - x
            if dists > diste:
                low = mid + 1
            else:
                high = mid 
        return arr[low:low+k]