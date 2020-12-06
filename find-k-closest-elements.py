class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        def binarySearch(arr,low,high,k,x):
            while low<=high:
                first = low+(high-low)//2
                last = first+k-1
                if (first>0 and (x-arr[first-1]<=arr[last]-x)):
                    high = first-1
                elif (last<len(arr)-1 and (x-arr[first]> arr[last+1]-x)):
                    low = first+1
                else:
                    return first
            return low
                    
        
        
        res=[]
        if arr is None or len(arr)==0:
            return res
        
        low =0; high = len(arr)-k
        first = binarySearch(arr,low,high,k,x)
        for i in range(first,first+k):
            res.append(arr[i])
        return res
