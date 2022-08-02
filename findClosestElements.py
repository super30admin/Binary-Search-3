# Time Complexity : O(log(n - k) + k)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        start = 0
        end = n - k
        while start < end:
            mid = (start + end) // 2
            if x - arr[mid] > arr[mid + k] - x:
                start = mid + 1
            else:
                end = mid
        return arr[start:start+k]
