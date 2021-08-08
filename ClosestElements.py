# Time Complexity : O(n)
# Space Complexity : O(n)

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