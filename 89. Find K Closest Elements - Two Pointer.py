# two pointer Solution

class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        result = []
        if arr is None or len(arr) == 0:
            return result

        low = 0
        high = len(arr) - 1

        while (high - low + 1) > k:

            distL = abs(arr[low] - x)

            distH = abs(arr[high] - x)

            if distL > distH:
                low += 1
            else:
                high -= 1

        for i in range(low, high + 1):
            result.append(arr[i])

        return result


obj = Solution()
print(obj.findClosestElements([1, 4, 5, 6, 7, 8, 15, 17, 19, 20], 5, 6))

# two pointer Solution
# TC =O(n).
# Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
