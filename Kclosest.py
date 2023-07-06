# // Time Complexity :O(log(n-k))
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
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
