# Time Complexity: O(log(n - k)) + O(k), where n - length of arr and k - no of closest integers
# Space Complexity: O(1)

# Solution:

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr or len(arr) == 0:
            return []

        result = []
        low = 0
        high = len(arr) - k

        while low < high:
            mid = low + (high - low) // 2
            ldist = x - arr[mid]
            rdist = arr[mid + k] - x

            if ldist > rdist:
                low = mid + 1
            else:
                high = mid

        for i in range(low, low + k):
            result.append(arr[i])

        return result





