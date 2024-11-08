# TC = O(logN + k) | SC = O(1)

class Solution:
    def findClosestElements(self, arr: list[int], k: int, x: int) -> list[int]:
        cnt = 0; n = len(arr)
        left, right = self.__findRangeBS(arr, x)

        if (left == right):
            cnt += 1
            left -= 1
            right += 1

        while (cnt < k):
            if (left >= 0 and right < n):
                if (x - arr[left] <= arr[right] - x):
                    left -= 1
                else:
                    right += 1
            elif (left < 0):
                right += 1
            else:
                left -= 1
            cnt += 1

        return arr[left + 1: right]

    def __findRangeBS(self, arr: list[int], x: int) -> tuple:

        lo = 0
        hi = len(arr) - 1

        while (lo + 1 < hi):

            mid = lo + int((hi - lo) / 2)
            if (x == arr[mid]):
                return (mid, mid)
            elif (x < arr[mid]):
                hi = mid
            else:
                lo = mid

        return (lo, hi)