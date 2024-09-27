# Time Complexity : O(log n)
# Space Complexity :O(k)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        #we are searching for the leftmost closest element to x in the array 
        #and returning k elements from there
        l=0
        r=len(arr)-k
        while(l<r):
            mid=l+(r-l)//2
            #now checking which elemnt is closer to the x 
            if (x-arr[mid]>arr[mid+k]-x):  
                l=mid+1
            else:
                r=mid
        return arr[l:l+k]