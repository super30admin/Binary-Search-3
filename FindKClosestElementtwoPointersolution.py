
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low =0
        high =len(arr)-1
        while(high-low+1>k):
            distL = abs(arr[low] -x)
            distH = abs(arr[high]-x)
            if(distL>distH):
                low+=1
            else:
                high-=1
        res=[]
        # for i in range(low,high+1):
        #     res.append(arr[i])
        return arr[low:low+k]
            
            
        
        
            
            
        
        