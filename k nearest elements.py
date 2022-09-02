# Time Complexity : O(n-k)    
# Space Complexity : O(1)    
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Optimized Binary Search
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l = 0
        r = len(arr) - k
        
        
        while l < r:
            mid = (l + r) // 2
            distL = x - arr[mid]
            distR = arr[mid + k] - x
            
            if distL > distR:
                l = mid + 1
                
            else:
                r = mid
                
        return arr[l: l + k]



# Time Complexity : O(nlogn + logk)    
# Space Complexity : O(n)    
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Bruteforce
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []

        for i in range(len(arr)):
            diff = arr[i] - x
            result.append(arr[i])
            
        result.sort()
        #print(result)
        return result[0 : k]
