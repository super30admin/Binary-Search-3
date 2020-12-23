class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res=[]
        if arr==None or len(arr)==0: return res
        low=0
        high=len(arr)-k # -k becouse we need k element what if last 4 element are in the res
        first=self.binary(arr,low,high,k,x)
        res=arr[first:first+k]
        return res
        
        
        
    
    def binary(self,arr,low,high,k,x):
     
        while low<high:
            first=low+(high-low)//2
            last=first+k-1
            if (first>0 and (x-arr[first-1]<=arr[last]-x)):
                high=first-1
            elif(last<len(arr)-1 and (x-arr[first]>arr[last+1]-x) ):
                low=first+1
            else:
                return first
        
        return low
                
        