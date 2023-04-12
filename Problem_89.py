# TC : O(N)
# SC : O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res = []
        l, r = 0, len(arr) - 1

        while r - l >= k:
            if abs(arr[l] - x) > abs(arr[r] - x):
                l = l + 1
            else:
                r = r - 1

        for i in range(l, r+1):
            res.append(arr[i])

        return res