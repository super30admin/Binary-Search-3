"""
2 pointer solution
TC : O(n-k)
SC : O(1)
"""

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        n = len(arr)
        left = 0
        right = n-1

        while right - left >= k:
            leftDiff = abs(x - arr[left])
            rightDiff = abs(x - arr[right])

            if leftDiff > rightDiff:
                left += 1
            else:
                right -= 1

        return arr[left: right+1]

"""
Binary search to find the start index
TC : O(log(n-k))
SC : O(1)
"""

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """

        low = 0
        high = len(arr) - k

        while low < high:
            mid = low + (high-low)//2
            if x - arr[mid] > arr[mid+k] - x:
                low = mid + 1
            else:
                high = mid
        return arr[low: low+k]
