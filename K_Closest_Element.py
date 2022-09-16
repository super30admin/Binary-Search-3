'''
Time Complexity - O(log(n-k))
Space Complexity - O(1)
'''


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low = 0
        high = n - k

        while low < high:
            mid = low + (high-low)//2
            distL = x - arr[mid]
            distR = arr[mid+k] - x
            if distL > distR:
                low = mid + 1
            else:
                high = mid
        res = []
        for i in range(low, low+k):
            res.append(arr[i])
        return res
