#two pointers time O(n-k), BS O(logn)+O(k)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l=0
        h=len(arr)-k
        res=[]
        while (h-l+1)>k:
            d1=abs(arr[l]-x)
            d2=abs(arr[h]-x)
            if d1>d2:
                l+=1
            else:
                h-=1
                
        for i in range(l,l+k):
            res.append(arr[i])
            
        return res
            
        while l<h:
            m=l+(h-l)//2
            d1=x-arr[m]
            d2=arr[m+k]-x
            
            if d1>d2:
                l=m+1
            else:
                h=m
                
        for i in range(l,l+k):
            res.append(arr[i])
            
        return res
            
            
        
