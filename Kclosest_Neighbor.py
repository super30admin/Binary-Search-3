"""658. Find K Closest Elements
Time Complexity: O(log(N-k))
Approach - Binary search on indexes"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        low = 0
        high = len(arr)-k
        
        while low<high:
            mid=(low+high)//2
            distF = x-arr[mid]
            distL = arr[mid+k]-x
            
            if distF>distL:
                low = mid+1
            else:
                high = mid
                
        for i in range(low,low+k):
            result.append(arr[i])
        return result
        
        
        
        
        
        
        
        
        

"""class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        2 pointer solution
        result = []
        if arr == None or len(arr)==0:
            return result
        low = 0
        high = len(arr)-1
        while high-low+1>k:
            distL = abs(x-arr[low])
            distR = abs(x-arr[high])
            if distL>distR:
                low+=1
            else:
                high-=1
        for i in range(low,high+1):
            result.append(arr[i])
        return result"""
                
            