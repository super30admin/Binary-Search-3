# Time Complexity : O(log(n-k))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
#

class Solution:
    def findClosestElements(self, arr: list[int], k: int, x: int) -> list[int]:
        start = 0
        end = len(arr) - k
        while start < end:
            mid = start + (end - start) // 2
            ds = x - arr[mid]
            de = arr[mid + k] - x
            if ds > de:
                start = mid + 1
            else:
                end = mid
        return arr[start:start + k]


print(Solution().findClosestElements([1, 2, 3, 4, 5], 4, 3))

# two-pointers
# TC: O(n-k); SC: O()
# class Solution:
#     def findClosestElements(self, arr, k: int, x: int):
#         start = 0
#         end = len(arr) - 1
#         while abs(start-end) != k-1:
#             ds = abs(arr[start]-x)
#             de = abs(arr[end]-x)
#             if ds > de:
#                 start += 1
#             else:
#                 end -= 1
#         result = []
#         for i in range(start, end+1):
#             result.append(arr[i])
#         return result


# TC: O(n*log(k)); SC: O(k)

# Using max-heap
# creating custom comparator
# import heapq
#
#
# class Comparator:
#     def __init__(self, value, distance):
#         self.value = value
#         self.distance = distance
#
#     def __lt__(self, other):
#         # if distances are equal, we need the lesser number.
#         # So we put the higher values at the top to get popped.
#         # else the distance with higher value gets popped.
#         if self.distance == other.distance:
#             return self.value > other.value
#         return self.distance > other.distance
#
#
# class Solution:
#     def findClosestElements(self, arr, k: int, x: int):
#         heap = []
#         # creating a max heap by comparing its distances
#         # if the size of heap > k, we pop the maximum distance element
#         for i in arr:
#             heapq.heappush(heap, Comparator(i, abs(x-i)))
#             if len(heap) > k:
#                 heapq.heappop(heap)
#         result = []
#         for i in heap:
#             result.append(i.value)
#         result.sort()
#         return result
#
#
# print(Solution().findClosestElements([1, 2, 3, 4, 5], 4, 3))


# without creating custom comparator
# class Solution:
#     def findClosestElements(self, arr, k: int, x: int):
#         heap = []
#         for i in arr:
#             heapq.heappush(heap, (-1*abs(x-i), -1*i))
#             if len(heap) > k:
#                 heapq.heappop(heap)
#         result = []
#         for i in heap:
#             result.append(-1*i[1])
#         result.sort()
#         return result
#
#
# print(Solution().findClosestElements([1, 2, 3, 4, 5], 4, 3))
