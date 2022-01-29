# time complexity: O(log(n-k))
# space complexity: O(1)


import math
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result=[]
        if arr==None or len(arr)==0: return result
        low=0
        high=len(arr)-1
        while(low<high):
            mid=math.floor((low+high)/2)
            dista=x-arr[mid]
            distb=arr[mid+k]-x
            
            if dista>distb:
                low=mid+1
            else:
                high=mid
                
            
#             distl=abs(x-arr[low])
#             disth=abs(x-arr[high])
            
#             if distl>disth:
#                 low+=1
                
#             else:
#                 high-=1
                    
        for i in range(low, high+1):
            result.append(arr[i])
            
        return result