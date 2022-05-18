#Find K Closest Elements
# // Time Complexity :  O(log n-k)+k
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def findClosestElements( arr, k, x):
    l,r=0, len(arr)-k
    while (l<r):
        m = (l+r)//2
        if(x-arr[m] > arr[m+k]-x):
            l=m+1
        else:
            r=m
    return arr[l:l+k]