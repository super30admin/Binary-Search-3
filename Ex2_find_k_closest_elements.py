# ----------------------------------------------------
# Intuition:
# We are given a sorted array and asked to return the k elements closest to a target x.
#
# A brute-force approach would be to compute distances, sort based on them, and return the k smallest.
# A better approach uses a max heap of size k to track the closest elements seen so far.
# A simpler linear solution shrinks a window from both ends until size k is reached.
# The most optimal solution uses Binary Search to find the best window of size k
# that minimizes the distance to x, leveraging the sorted property of the array.
# ----------------------------------------------------

# ----------------------------------------------------
# Time Complexity: O(log(n - k) + k)
# - Binary search runs in O(log(n - k)) to find starting index of window
# - Extracting the window of size k takes O(k)
#
# Space Complexity: O(1)
# - We return a slice of the original array; no extra structures are used
# ----------------------------------------------------

from typing import List
import heapq


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left, right = 0, len(arr) - k
        while left < right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left + k]

# ------------------------------------------------------
# Two Pointer Shrinking Window Approach

# Time Complexity: O(n - k)
# - Initially the window is size n
# - We shrink the window by removing 1 element at a time until it becomes size k
# - So we perform (n - k) iterations, each in O(1) time
# - Extracting the final k elements as a slice takes O(k)
# → Total: O(n - k + k) = O(n)
#
# Space Complexity: O(1)
# - No extra space used apart from the output slice (which reuses input elements)
#
# Intuition:
# - Since the array is sorted, the k closest elements will form a continuous window
# - Remove elements from the side that is farther from x
#
#         left, right = 0, len(arr) - 1
#         while right - left + 1 > k:
#             if abs(arr[left] - x) > abs(arr[right] - x):
#                 left += 1
#             else:
#                 right -= 1
#         return arr[left:right + 1]

# ------------------------------------------------------
# Max Heap Approach
#
# Time Complexity: O(n log k)
# - Each of the n elements is pushed into the heap
# - Maintaining the heap of size k costs log k per insertion
#
# Space Complexity: O(k)
# - The heap stores k elements at most
#
# Intuition:
# - Push tuples of (distance, -value) into a max heap to keep closest elements
# - Use negative values to break ties by smaller value
#
#         max_heap = []
#         for num in arr:
#             heapq.heappush(max_heap, (-abs(num - x), -num))
#             if len(max_heap) > k:
#                 heapq.heappop(max_heap)
#         result = []
#         for _, num in max_heap:
#             result.append(-num)
#         result.sort()
#         return result

# ------------------------------------------------------
# Brute Force Approach (Sort by Distance)
#
# Time Complexity: O(n log n)
# - Sorting all n elements by distance and value
# - Slicing and sorting final k elements costs additional O(k log k)
#
# Space Complexity: O(n)
# - We create a sorted list of all elements
#
# Intuition:
# - Sort entire array based on (abs(a - x), a)
# - Pick first k elements and sort for output
#
#         arr.sort(key=lambda num: (abs(num - x), num))
#         return sorted(arr[:k])


if __name__ == "__main__":
    sol = Solution()

    # Test Case 1
    arr = [1, 2, 3, 4, 5]
    k = 4
    x = 3
    print(sol.findClosestElements(arr, k, x))  # Output: [1, 2, 3, 4]

    # Test Case 2
    arr = [1, 1, 2, 3, 4, 5]
    k = 4
    x = -1
    print(sol.findClosestElements(arr, k, x))  # Output: [1, 1, 2, 3]

    # Test Case 3
    arr = [10, 20, 30, 40, 50]
    k = 3
    x = 35
    print(sol.findClosestElements(arr, k, x))  # Output: [20, 30, 40]

    # Test Case 4
    arr = [1, 2, 3, 4, 5]
    k = 4
    x = 6
    print(sol.findClosestElements(arr, k, x))  # Output: [2, 3, 4, 5]

    # Test Case 5
    arr = [1]
    k = 1
    x = 1
    print(sol.findClosestElements(arr, k, x))  # Output: [1]
