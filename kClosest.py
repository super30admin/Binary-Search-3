# Time Complexity : O(n-k), where n is the size of the arr
# Space Complexity : O(k)

class Solution:
    def findClosestElements(self, arr, k, x):
        low, high = 0, len(arr) - 1

        while high - low >= k:
            if abs(arr[low] - x) <= abs(arr[high] - x):
                high -= 1
            else:
                low += 1

        return arr[low:high + 1]

# Examples
solution = Solution()

# Example 1
arr1, k1, x1 = [1, 2, 3, 4, 5], 4, 3
print("findClosestElements({}, {}, {}) = {}".format(arr1, k1, x1, solution.findClosestElements(arr1, k1, x1)))  # Expected output: [1, 2, 3, 4]

# Example 2
arr2, k2, x2 = [1, 2, 3, 4, 5], 4, -1
print("findClosestElements({}, {}, {}) = {}".format(arr2, k2, x2, solution.findClosestElements(arr2, k2, x2)))  # Expected output: [1, 2, 3, 4]

# Example 3
arr3, k3, x3 = [1, 2, 3, 4, 5], 2, 3
print("findClosestElements({}, {}, {}) = {}".format(arr3, k3, x3, solution.findClosestElements(arr3, k3, x3)))  # Expected output: [2, 3]