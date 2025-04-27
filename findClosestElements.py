# Approach:
# - Use Binary Search to find the left boundary of the k closest elements window.
# - Compare distances between x and window edges: 
#   if x - arr[mid] > arr[mid+k] - x, move right; else move left.
# - Return the subarray starting from the found left index with size k.
#
# Time Complexity: O(log(n-k)), because we binary search over a window of size (n-k).
# Space Complexity: O(1), ignoring the space for output.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l, r = 0, len(arr) - k
        while l < r:
            m = (l + r) // 2
            if x - arr[m] > arr[m + k] - x:
                l = m + 1
            else:
                r = m
        return arr[l:l+k]
