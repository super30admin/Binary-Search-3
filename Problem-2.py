# 658. Find K Closest Elements

# Code:

# Logic: Standard Binary search with one edge case (duplicates)


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr)-k
        
        res = []
        
        while low<high:
            mid  = low+(high-low)//2
            
            left = abs(x - arr[mid])
            right = abs(x - arr[mid+k])

            if left>right:
                low = mid+1
            else:
                if arr[mid]==arr[mid+k]:
                    low = mid+1
                else:
                    high = mid
        
        
        for i in range(low, low+k):
            res.append(arr[i])
        
        return res



# Time Complexity: O(logn)
# Space Complexity: O(K)
# Accepted on Leetcode: Yes.