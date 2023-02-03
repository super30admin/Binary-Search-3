# Time Complexity :O(log(n-k))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


class Solution(object):
    def findClosestElements(self, arr, k, x):
        l,r=0,len(arr)-k
        while(l<r):
            mid=(l+r)//2
            if(x-arr[mid] > arr[mid+k]-x):
                l=mid+1
            else:
                r=mid
            

        return(arr[l:l+k])


       