# Time Complexity-O(logn)
#space Complexity-O(n)
//Two Pointer
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if(len(arr)==0):
            return []
        l=0
        h=len(arr)-1
        res=[]
        while(h-l > k-1):
            distL=abs(x-arr[l])
            distR=abs(x-arr[h])
            if(distL > distR):
                l+=1
            else:
                h-=1
        for i in range(l,l+k):
            res.append(arr[i])
        return res
            
  /// Binary Search
  class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if(len(arr)==0):
            return []
        l=0
        h=len(arr)-k
        res=[]
        while(l < h):
            mid=l+((h-l)//2)
            distL=abs(arr[mid]-x)
            distR=abs(arr[mid+k]-x)
            if(distL > distR):
                l=mid+1
            else:
                h=mid
        for i in range(l,l+k):
            res.append(arr[i])
        return res
