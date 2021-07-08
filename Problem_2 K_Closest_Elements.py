# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
# Approach: 2 pointers
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        if arr == None or len(arr) == 0:
            return result

        low = 0
        high = len(arr) - 1
        while high - low + 1 > k:
            dist_l = x - arr[low]
            dist_h = arr[high] - x
            if dist_l > dist_h:
                low += 1
            else:
                high -= 1
        for i in range(low, high + 1):
            result.append(arr[i])
        return result

# Approach: Binary Search
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        low = 0
        high = len(arr) - k
        while low < high:
            mid = low + (high - low) // 2
            #Finding the first index
            dist_f = x - arr[mid]
            #Finding the last index
            dist_l = arr[mid + k] - x
            if dist_f > dist_l:
                low = mid + 1
            else:
                high = mid

        for i in range(low, low + k):
            result.append(arr[i])
        return result

