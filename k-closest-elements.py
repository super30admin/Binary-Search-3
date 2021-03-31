"""
TC: logn - binary search?
SC: O(k) as I am storing it in a different list
Leetcode: Not Successful.
Problem: Failing for the test case mentioned below.
"""

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
       
        if arr == None or len(arr) == 0:
            return -1
        if len(arr) == 1:
            return arr
        
        low = 0
        high = len(arr) - 1
        res = []
        while low < high and len(res) < k:
            mid  = int(low + (high - low)/2)
            if mid == x:
                res.append(arr[mid])
            if (abs(arr[low]-x)< abs(arr[high]-x)) or(abs(arr[low]-x) == abs(arr[high]-x) and low<high):
                res.append(arr[low])
                low += 1
            else:
                res.append(arr[high])
                high -= 1
        return sorted(res)
      
        """
        Failing test case: 
        
        [-2,-1,1,2,3,4,5]
        7
        3
        """
                
                
                        
            
            
