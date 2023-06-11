#Time Complexity:O(log(n-k))
#Space Complexity:O(1)

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        l = 0
        r = len(arr) - k
        while l < r:
            mid = l + (r - l) // 2
            if x - arr[mid] > arr[mid + k] - x:
                l = mid + 1
            else:
                r = mid
        return [arr[i] for i in range(l, l + k)]