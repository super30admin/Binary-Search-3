# Time Complexity : O(log n + k), where n is the length of the input array.
# Space Complexity : O(k) 
import bisect
from typing import List

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # Find the index of the element in the array that is closest to x
        index = bisect.bisect_left(arr, x)
        
        # Set the left and right pointers initially to the closest index
        left = index - 1
        right = index
        
        # Expand the window around x until we have k closest elements
        while k > 0:
            # If the left pointer is out of bounds or the right pointer is in bounds and closer to x
            if left < 0 or (right < len(arr) and abs(arr[left] - x) > abs(arr[right] - x)):
                right += 1
            else:
                left -= 1
            k -= 1
        
        # Return the k closest elements
        return arr[left + 1:right]