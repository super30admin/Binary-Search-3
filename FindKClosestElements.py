# Time Complexity : O(logn)+k
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Binary Search. Initialize a queue and append the element at the closest index that is found in binary search to x
# Initialize left pointer 1 before the closest element and right to1 after the closest element
# Iterate until k becomes 1 and check the boundary conditions
# If left goes out of bounds then increment right by 1 and append right
# If right goes out of bounds then decrement left by 1 and append left to the left of queue
# Else check if abs distance between left and x is greater than abs distance between right and x then increment right by 1 and append right
# Else append left to the left of the queue and decrement left by 1
# Return queue

from collections import deque


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr:
            return None
        closest = self.binarySearch(arr, x)
        res = deque([arr[closest]])
        left = closest - 1
        right = closest + 1
        while k > 1:
            if left < 0:
                res.append(arr[right])
                right += 1
            elif right == len(arr):
                res.appendleft(arr[left])
                left -= 1
            else:
                if (abs(x - arr[left]) > abs(x - arr[right])):
                    res.append(arr[right])
                    right += 1
                else:
                    res.appendleft(arr[left])
                    left -= 1
            k -= 1

        return list(res)

    def binarySearch(self, arr, x):
        left = 0
        right = len(arr) - 1

        while left < right:
            mid = left + (right - left) // 2
            if arr[mid] == x:
                return mid
            elif arr[mid] > x:
                right = mid
            else:
                left = mid + 1
        if left == 0:
            return left
        if abs(x - arr[left]) < abs(x - arr[left - 1]):
            return left
        return left - 1
