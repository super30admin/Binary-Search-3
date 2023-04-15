class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # Two Pointer Approach
        # Time Complexity: O(n)
        # Space Complexity: O(1)
        # low = 0
        # high = len(arr) - 1
        # while (high - low) >= k:
        #     if (x - arr[low]) > (arr[high] - x):
        #         low += 1
        #     else:
        #         high -= 1
        # return arr[low: high+1]

        # Binary Search Approach
        left, right = 0, len(arr) - k
        while left < right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left + k]