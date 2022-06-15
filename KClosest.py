# TC - O(log n)
# SC - O(1)
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        result = []
        if len(arr) == k:
            for i in range(k):
                result.append(arr[i])
            return result

        def findClosest():
            l = 0
            r = len(arr)

            while l < r:
                mid = (r+l)//2

                if arr[mid] >= x:
                    r = mid
                else:
                    l = mid + 1
            return l

        def findKClosestElements():
            left = findClosest() - 1
            right = left + 1

            while (right - left - 1 < k):
                if left == -1:
                    right = right + 1
                    continue

                if right == len(arr) or abs(arr[left] - x) <= abs(arr[right] - x):
                    left = left - 1
                else:
                    right = right + 1

            return left, right

        left, right = findKClosestElements()

        for i in range(left + 1, right):
            result.append(arr[i])

        return result
