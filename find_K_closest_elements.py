# Approach:
# Use a binary search to find the potential starting point of the k closest elements to x. 
# Use a two-pointer technique to expand and identify the k closest elements around the starting point.
# Return the sorted list of k closest elements since the array is already sorted.

# Time Complexity: O(log(n) + k), where n is the length of the array (binary search takes O(log(n)), 
# and the two-pointer approach runs for k elements).
# Space Complexity: O(1), since no extra space proportional to the input size is used.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # Perform binary search to find the closest element to x
        left, right = 0, len(arr) - 1
        while left < right:
            mid = (left + right) // 2
            # Narrow down the range to the part closer to x
            if arr[mid] >= x:
                right = mid
            else:
                left = mid + 1
        
        # Initialize two pointers for the sliding window
        left, right = left - 1, left
        
        # Expand the window to include k closest elements
        while right - left - 1 < k:
            if left < 0:  # If left pointer is out of bounds, move the right pointer
                right += 1
            elif right >= len(arr):  # If right pointer is out of bounds, move the left pointer
                left -= 1
            elif abs(arr[left] - x) <= abs(arr[right] - x):  # Compare distances from x
                left -= 1
            else:
                right += 1

        # Return the k elements in sorted order
        return arr[left + 1:right]
