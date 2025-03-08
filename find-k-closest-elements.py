#  binary search to find the best starting index for the k closest elements by comparing the distance between x and the two 
#  endpoints of each potential window. Once the optimal window is found, we return the k elements starting from that index.
# Time & Space Complexity Analysis
# Binary Search: O(log n)
# Returning k elements: O(k)
# Total Complexity: O(log n + k) (Efficient!)
# Space Complexity: O(1) (In-place search, no extra storage)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0 
        right = len(arr) - k
        while left < right: 
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left + k]
        