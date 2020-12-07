"""
Time complexity O(log(N-k))
space complexity O(1)


"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res=[]
        if(arr is None or len(arr)==0):
            return res
        low=0
        high=len(arr)-k
        first=self.binarysearch(arr,low,high,k,x)
        for i in range(first,first+k):
            res.append(arr[i])
        return res
    
    
    def binarysearch(self,arr,low,high,k,x):
        while(low<high):
            mid=low+(high-low)//2
            last=mid+k
            if(x-arr[mid]<=arr[last]-x):
                high=mid
            else:
                low=mid+1
        return low
            
            
