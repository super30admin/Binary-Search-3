# Time Complexity : O(log(n - k) + k)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use binary search on the starting index of the window of size k.
# Search between 0 and n-k to find the best window.
# Compare distances of x with arr[mid] and arr[mid + k].
# If left side is farther, move right; otherwise move left.
# Final window starting index gives the k closest elements.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        res = []
        low = 0
        high = n - k

        while low < high:
            mid = (low + high) // 2
            start = x - arr[mid]
            end = arr[mid + k] - x

            if start > end:
                low = mid + 1
            else:
                high = mid
        
        for i in range(low,low + k):
            res.append(arr[i])
        return res