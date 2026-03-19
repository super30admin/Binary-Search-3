# Time Complexity : O(log(n - k)) for binary search on the window start and O(k) to collect the result
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We binary search the best starting index for the k closest elements.
# At each step, we compare the distance between start and end of the current window.
# Once found, we take the k elements starting from that index.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low, high = 0, n - k

        while low < high:
            mid = low + (high - low) // 2

            distS = x - arr[mid]
            distE = arr[mid+k] - x

            if distS > distE:
                low = mid + 1
            else:
                high = mid

        res = []
        for i in range(low, low + k):
            res.append(arr[i])

        return res

        