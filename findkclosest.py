# Time Complexity : O(log N) where N is the number of elements in the array
# Space Complexity : O(1) where N is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using binary search to find the k closest elements to x.
# I am maintaining a sliding window of size k and adjusting the left and right pointers accordingly.
# The final result is the subarray of size k starting from the left pointer.

from typing import List
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr) - k
        ans = []
        
        while left < right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid+k] - x:
                left = mid + 1
            else:
                right = mid
        print(left)
        return arr[left:left+k]
            

        