# class Solution:
#     def findClosestElements(self, arr,k,x):
#         n = len(arr)
#         left = 0
#         right = n - 1
#         while (right - left + 1) != k:
#             leftDiff = abs(arr[left] - x)
#             rightDiff = abs(arr[right] - x)
#             if rightDiff >= leftDiff:
#                 right -= 1
#             else:
#                 left += 1

#         result = []
#         for i in range(left, right + 1):
#             result.append(arr[i])
#         return result


class Solution:
    def findClosestElements(self, arr,k,x):
        n = len(arr)
        low, high = 0, n - k
        while low < high:
            mid = (low + high) // 2
            if x - arr[mid] > arr[mid + k] - x:
                low = mid + 1
            else:
                high = mid
        return arr[low : low + k]
