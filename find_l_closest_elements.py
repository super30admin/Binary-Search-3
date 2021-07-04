"""
Time Complexity : findClosestElements_binarySearch() - O(log n)
                  findClosestElements_twoPointer - O(n)
Space Complexity : findClosestElements_binarySearch() - O(1)
                   findClosestElements_twoPointer - O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def findClosestElements_binarySearch(self, arr, k, x):
        l = 0
        h = len(arr) - k
        
        while l < h:
            mid = l + (h-l) // 2
            dist_L = abs(arr[mid] - x)
            dist_R = abs(arr[mid+k] - x)
            
            if dist_L > dist_R:
                l = mid + 1
            else:
                h = mid
                
        return arr[l:l+k]
    
    def findClosestElements_twoPointer(self, arr, k, x):
        l = 0
        r = len(arr) - 1
        
        while (r - l) >= k:
            dist_L = abs(x-arr[l])
            dist_R = abs(x-arr[r])
            
            if dist_L > dist_R:
                l += 1
            else:
                r -= 1
                
        return arr[l: r+1]
    
s = Solution()
print(s.findClosestElements_binarySearch([1,1,1,10,10,10],1,9))