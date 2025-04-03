# time Complexity : O(n)
# Space Compexity : O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) == 0 and k > len(arr):
            return []
        result = []
        left = 0
        right = len(arr) -1
        while (right - left + 1) > k:
            startDistance = x - arr[left]
            endDistance = arr[right] - x
            if startDistance >endDistance:
                left = left + 1
            else:
                right = right - 1
        for i in range(left, right+1):
            result.append(arr[i])
        return result