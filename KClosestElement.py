"""
Time Complexity : O(log(n - k))
Space Complexity : O(1)
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l = 0
        h = len(arr) - k

        while (l < h):
            m = l + (h - l) // 2
            dist_s = x - arr[m]
            dist_e = arr[m + k] - x

            if dist_s > dist_e:
                l = m + 1
            else:
                h = m

        result = []
        for i in range(l, l + k):
            result.append(arr[i])

        return result