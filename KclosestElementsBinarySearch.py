'''Time Complexity: O(n-k)
Space Complexity: O(1)'''

class Solution(object):
            
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        #Optimized binary search method
        if len(arr)==0:
            return []
        #Binary Search
        n=len(arr)
        low=0
        high=n-k #start index will never go beyond n-k
        #Till the gap is greated than k, keep on reducing the gap
        while low < high :
            mid=low+(high-low)//2
            #assuming the start as mid
            start_dis=x-arr[mid]
            #therefore range will be from mid to mid+k
            end_dis=arr[mid+k]-x
            if start_dis > end_dis:
                low=mid+1
            else:
                high=mid
        
        #Now low will be the start index of the range
        result=[]
        for i in range(low, low+k):
            result.append(arr[i])
        return result
        
