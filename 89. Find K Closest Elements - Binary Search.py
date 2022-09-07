# Binary Search
class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        result = []
        if arr is None or len(arr) == 0:
            return result

        low = 0
        high = len(arr) - k

        while low < high:
            mid = low + (high - low) // 2
            distS = x - arr[mid]
            distE = arr[mid + k] - x

            if distS > distE:
                low = mid + 1
            else:
                high = mid
        # print(low, low+k)
        for i in range(low, low + k):
            result.append(arr[i])

        return result


# Binary Search
# Output : [1, 3]
obj = Solution()
print(obj.findClosestElements([0, 0, 0, 1, 3, 5, 6, 7, 8, 8], 2, 2))

# two pointer Solution
# TC =O(log(n - k)).
# Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
