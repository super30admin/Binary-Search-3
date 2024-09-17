# Time Complexity : O(log n) where n is the number of elements in the array
# Space Complexity :O(k)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

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
        return [arr[i] for i in range(left, left + k)]

# In this Problem we first try to find the pointer which will be the starting pointer for our resultant elements. For
# that first will move the left and right index such that the distance from the left and right index is the same from the
# element (x) that we want. Then after we iterate till our both left and right are at same index. Then iteration is done for k values.