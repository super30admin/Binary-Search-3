"""
Binary search approach
TC - O(log n k) + k
log n - k ==> BS
k ==> to iterate over k elements at the end

SC - O(1)
"""


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if arr is None or len(arr) == 0 or k is None or x is None: return []

        n = len(arr)
        low = 0
        # since elements can lie of either side of range
        high = n - k

        rtnData = []

        # to find the starting point of the k elements
        while low < high:
            mid = low + (high - low) // 2

            # starting point of the range to perform BS
            distS = x - arr[mid]
            # ending point of the range to perform BFS
            distE = arr[mid + k] - x

            if distS > distE:
                low = mid + 1
            else:
                high = mid

        for i in range(low, low + k):
            rtnData.append(arr[i])

        return rtnData