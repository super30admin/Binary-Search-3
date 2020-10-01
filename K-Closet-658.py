# Time Complexity : O(logn)
# Space Complexity : O(1)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#With binary search get the value where to move either left or right of array.
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        low = 0
        high = len(arr) - k
        
        while low < high:
            mid = low + (high-low) // 2
            
            L_D = abs(x - arr[mid])
            R_D = abs(x - arr[mid + k])
            
            if L_D > R_D:
                low = mid + 1
            else:
                if (arr[mid] == arr[mid + k]):
                    low = mid + 1
                else:
                    high = mid
        
        output = []
        for i in range(low, low + k):
            output.append(arr[i])
        
        return output
