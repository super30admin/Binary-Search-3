#find k closest
# Time: O(log(N-K) + K) where n is the number of elements in the lst and K is the new sliced list
# Space: O(K)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        startIdx = 0  # ans is the starting index of result array
        left, right = 0, n - k
        while left <= right:
            mid = (left + right) >> 1
            if mid+k == n or x - arr[mid] <= arr[mid+k] - x:
                startIdx = mid  # Found a valid answer -> Update
                right = mid - 1  # Try to find the left most answer in the left side
            else:
                left = mid + 1  # Find in the right side
        return arr[startIdx:startIdx+k]