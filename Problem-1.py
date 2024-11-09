#Approach
# Assign the low to zero and high to n-k that tis the maximun index can acheive by the start of the index.
# we will find the mid distance and mid +k distance every time if mid is less than mid+k then high = mid else low =mid+1


# Complexities
# Time: O(log n) +O(k)
#Space :O(1)

from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        low = 0
        high = len(arr) - k

        while low < high:
            mid = int((low + high) / 2)
            distA = x - arr[mid]
            distB = arr[mid + k] - x

            if distA > distB:
                low = mid + 1
            else:
                high = mid
        return arr[low:low + k]
