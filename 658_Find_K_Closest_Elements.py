"""
TC -> O(k+log N)
SC -> O(1) no extra space used
Logic
1. find insert position(ip) of x in array
2. Consider range [ip-k, ip+k] and perform two pointer logic.
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        def binary_search(arr, _length, x):
            l = 0
            h = _length - 1
            while (l <= h):
                mid = l + (h - l) // 2
                if arr[mid] == x:
                    return mid
                elif arr[mid] > x:
                    h = mid - 1
                else:
                    l = mid + 1
            return l

        def two_pointer(arr, start, end, x):
            while ((end - start + 1) > k):
                if abs(arr[start] - x) > abs(arr[end] - x):
                    start += 1
                else:
                    end -= 1
            return arr[start:end + 1]

        length = len(arr)
        if length == 1:
            return arr
        if x > arr[-1]:  # if x is greater than last value, return last k elements
            return arr[length - k:length]
        if x < arr[0]:  # if x is lesser than first value, return first k elements
            return arr[:k]
        insert_pos = binary_search(arr, length,
                                   x)  # find the insert position of x and then consider [insert_idx-k, insert_idx+k]
        start = max(0, insert_pos - k)  # to guard against going out of bounds
        end = min(insert_pos + k, length - 1)  # to guard against going out of bounds
        return two_pointer(arr, start, end, x)  # two pointer logic to find the correct start and end index

