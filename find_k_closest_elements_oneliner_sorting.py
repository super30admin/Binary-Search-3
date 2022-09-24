# Time Complexity : O(n log n) + O(k) where n length of the array and k is number closest elements to findout
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        return sorted(sorted(arr, key=lambda num :abs(x-num))[:k])