# Time Comlpexity: O(log(n-k)+k)
# Space Complexity: O(1)
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        #curr = 0
        l = 0
        r = len(arr) - k
        while l < r:
            m = l +(r-l)/2
            left =  x - arr[m]
            right = arr[m+k] - x
            if left > right:
                l = m + 1
            else:
                r = m
            
        return arr[l:l+k]
