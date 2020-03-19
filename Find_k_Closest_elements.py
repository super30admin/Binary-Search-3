# Time complexity --> o(logn)+o(k)  
# space complexity --> o(k)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we have used binary search to solve this problem.we set low and high pointers in the array.then we check the distance between x with the start and end of the window to check which side of elements are near to x.At the end we end with a window of length x which are closest to the element x.

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        if arr==None or len(arr)==0:
            return []
        low=0
        high=len(arr)-k
        while low<high:
            mid=low+(high-low)/2
            if abs(arr[mid]-x)>abs(arr[mid+k]-x):
                low=mid+1
            else:
                high=mid
        result=[]
        for i in range(k):
            result.append(arr[low+i])
        return result