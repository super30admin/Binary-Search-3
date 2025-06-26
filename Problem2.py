# Time Complexity : O(log(n-k))
# Space Complexity : O(k) to store result k
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
#1. The function uses binary search to find the k closest elements to x.
#2. we maintain a start index and end index to narrow down on the distance from x for k closest elements.
#3. The final result is a list of the k closest elements, sorted in ascending order.

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        low=0
        #set high pointer to the last index of the array minus k
        #because this eliminates the elements that are arr[i]-x distance greater than the kth closest element
        high=len(arr)-k
        #binary search to find the starting index of the kth closest element
        while low<high:
            #set mid pointer to the middle of the current range
            mid=low+(high-low)/2
            #if the distance from x for mid element is greater than the distance from x for mid+k element,
            #it means we need to move the low pointer to mid+1 to find a closer element
            distS=x-arr[mid]
            distE=arr[mid+k]-x
            #if the start index is greater than end index then the closest element will be on the right side
            
            if distS>distE:
                low=mid+1
            else:
                #if the distance from x for mid element is less than or equal to the distance from x for mid+k element,
                #it means we need to move the high pointer to mid to find a closer element
                high=mid
        #after the binary search, low will be the starting index of the k closest elements
        #we return the subarray from low to low+k which will contain the k closest elements
        res=[]
        for i in range(low,low+k):
            res.append(arr[i])
        return res
    
