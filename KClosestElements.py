# Time Complexity: O(log n) + O(k) where n is the length of the array and k is the number of closest elements.
# Space Complexity: O(1).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr) - 1
        result = []
        while right - left + 1 > k:
            leftDist = x - arr[left]
            rightDist = arr[right] - x
            if leftDist > rightDist:
                left += 1
            else:
                right -= 1
        for i in range(left, left + k):
            result.append(arr[i])
        return result