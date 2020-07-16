-------------------------------- Find k closest elements---------------------------------------------
# Time Complexity : O(n-k)+O(k)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# I Here I used 2 pointer approach, low will start from 0 and high will start from len(arr)-1. I will iterate by calculating the distance of
#element - arr[low] and element-arr[high]. if my left distance if greater than right distance, I will increment my low pointer, else I will decrement my high pointer.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr)-1
        while abs(low-high)>=k:
            distL = abs(x-arr[low])
            distR = abs(x-arr[high])
            if distL>distR:
                low+=1
            else:
                high-=1
        
        return arr[low:high+1]
        

------------------- Binary Search (Works only if arr is without duplicate elements)----------------------------------

# Time Complexity : O(log(n-k)+O(k)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# In this approach binary search is used, where my low will be at 0 and high will be at n-k position. I will calculate mid and 
#iterate until my low equals high pointer. I will calculate the distance between mid and target  and compares with distance between target and arr[mid+k]
# If my distanceL is greater than [mid+k] and target, I will move my low to mid+1, else I will move high to mid.



class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr)-k
        while low<high:
            mid = (low+high)//2
            
            distL = abs(x-arr[mid])
            distR = abs(x-arr[mid+k])
            if distL>distR:
                low = mid+1
            else:
                high = mid
                
        
        return arr[low:low+k]