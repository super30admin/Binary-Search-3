class Solution:
    # Time Complexity: O(log (n-k))
    # Space Complexity: O(1)
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - 1
        while high - low + 1 > k:
            if x - arr[low] <= arr[high] - x:
                high -= 1
            else:
                low += 1
        return arr[low : high + 1]
