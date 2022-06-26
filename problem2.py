class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        l = 0
        h  = len(arr)-1
        
        while(h-l+1!=k):
            
            if(abs(x-arr[l])>abs(x-arr[h])):
                l+=1
            else:
                h-=1
        return arr[l:h+1]