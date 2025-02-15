# Time Complexity = O(n)
# Space Complexity = O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left, right = 0, len(arr) - 1
        while left < right:
            mid = (left + right) // 2
            if arr[mid] < x:
                left = mid + 1
            else:
                right = mid
        #Two-pointer technique to find k closest elements
        left, right = left - 1, left
        while k > 0:
            if left < 0:
                right += 1
            elif right >= len(arr) or abs(arr[left] - x) <= abs(arr[right] - x):
                left -= 1
            else:
                right += 1
            k -= 1
        return arr[left + 1:right]