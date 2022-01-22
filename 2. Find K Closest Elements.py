class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        # Time Complexity - O(logN)
        # Space Complexity - O(1)
        l = 0
        r = len(arr) - k

        while l < r:
            mid = l + (r - l) // 2

            if x - arr[mid] > arr[mid + k] - x:
                l = mid + 1
            else:
                r = mid
        # after the loop, l points to the starting index of the final answer
        return arr[l: l + k]