# Time Complexity: O(log(n))
# Space complexity : O(1)
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        if x <= arr[0]: return arr[:k]
        if x >= arr[-1]: return arr[-k:]
        l,r = 0, len(arr)-k
        while l <r:
            m =(l+r)>>1
            if x-arr[m]> arr[m+k]-x:
                l = m + 1
            else:
                r = m
        return arr[l:l+k]
        