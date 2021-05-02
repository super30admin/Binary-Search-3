class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res = deque()
        if arr is None or len(arr) == 0:
            return res
        closest = self.bs(arr, x)
        left = closest - 1
        right = closest + 1
        res.appendleft(arr[closest])

        while k > 1:
            if left < 0:
                res.append(arr[right])
                right += 1

            elif right == len(arr):
                res.appendleft(arr[left])
                left -= 1

            else:
                if x - arr[left] <= arr[right] - x:
                    res.appendleft(arr[left])
                    left -= 1

                else:
                    res.append(arr[right])
                    right += 1
            k -= 1
        return res

    def bs(self, arr, x):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = low + (high - low) // 2
            if arr[mid] == x:
                return mid
            elif x > arr[mid]:
                low = mid + 1
            else:
                high = mid
        if low == 0:
            return low
        if (abs(arr[low] - x)) < abs(arr[low - 1] - x):
            return low
        else:
            return low - 1
