# Brute force Solution
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        arr.sort(key = lambda y: abs(x-y))
        result = []
        for i in range(k):
            result.append(arr[i])
        result.sort()
        return result

# Time Complexity: O(n * log(n)) + (k * log (k))
# Space Complexity: O(1)


# Two Pointer solution
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        if arr == None or len(arr) == 0:
            return result
        low, high = 0, len(arr) - 1
        while high - low + 1 > k:
            dfirst = abs(x - arr[low])
            dlast = abs(arr[high] - x)
            if dfirst > dlast:
                low += 1
            else:
                high -= 1
        for i in range(low, high + 1):
            result.append(arr[i])
        return result


# Time Complexity: O(n)
# Space Complexity: O(1)


# Binary Search Solution
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        if arr == None or len(arr) == 0:
            return result
        low, high = 0, len(arr) - k
        while low < high:
            mid = low + (high-low) // 2
            dfirst = x - arr[mid]
            dlast = arr[mid + k] - x
            if dfirst > dlast:
                low = mid + 1
            else:
                high = mid
        for i in range(low, low + k):
            result.append(arr[i])
        return result

# Time Complexity: O(log(n-k))
# Space Complexity: O(1)


