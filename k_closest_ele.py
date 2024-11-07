# #two pointer method
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left, right = 0, len(arr) - 1

        while right - left + 1 > k:

            if abs(arr[left] - x) > abs(arr[right] - x):
                left += 1
            else:
                right -= 1

        return arr[left : right + 1]


# time complexity is O(n-k)
# space complexity is O(k)


# binary search
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        left = 0
        right = len(arr) - k

        mid = (left + right) // 2

        if x - arr[mid] > arr[mid + k] - x:
            left = mid + 1
        else:
            right = mid
        return arr[left : left + k]


# time complexity is  O(log(n - k) + k)
# space complexity is O(k)
