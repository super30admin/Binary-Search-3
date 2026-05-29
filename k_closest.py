class Solution:
    def findClosestElements(self, arr, k, x):
        n = len(arr)
        low, high = 0, n - k

        while low < high:
            mid = low + (high - low) // 2

            distS = x - arr[mid]
            distE = arr[mid + k] - x

            if distS > distE:
                low = mid + 1
            else:
                high = mid

        result = []
        for i in range(low, low + k):
            result.append(arr[i])

        return result

# Time: O(log(n - k))
# Space: O(1)