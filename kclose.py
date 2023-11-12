# // Time Complexity :O(log(n-k)+k)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we initialize  two ptrs - l and r. we update l to be wehre the val is closer to x and it wil be a k size window. we do the binary search to update these boundaries.
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        l,r=0,len(arr)-k
        while(l<r):
            m=(l+r)//2
            if(x-arr[m]>arr[m+k]-x):
                l=m+1
            else:
                r=m
        return arr[l:l+k]
