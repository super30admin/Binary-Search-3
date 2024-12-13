# The findClosestElements method finds the k closest elements to x in a sorted array.

# Use a two-pointer approach:
# - Narrow the window by comparing the distance of x to elements at 'left' and 'right'.
# - Increment 'left' or decrement 'right' until the window size equals k.

# Return the sorted subarray within the final window.

# TC: O(n) - Window narrowing, plus O(k log k) for sorting the result.
# SC: O(k) - Space for the result.


from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr) - 1
        
        while right - left >= k:
            if abs(x - arr[left]) > abs(x - arr[right]):
                left += 1
            else:
                right -= 1
        
        return sorted(arr[left:right+1])