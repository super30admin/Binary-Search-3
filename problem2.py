'''#using heap
#time comp- (nlogk)
#space comp- O(k) 
import heapq
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap=[]
        for i in range(0,len(arr)):
            heappush(heap,(abs(arr[i]-x),arr[i]))
        #print(heap)
        ans=[]
        for _ in range(k):
            dist,val=heappop(heap)
            print(dist,val)
            ans.append(val)
        return sorted(ans)'''
#efficient Using two pointers time- O(n)
#space -O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l=0
        r=len(arr)-1
        ans=[]
        while r-l+1>k:
            ldist=x-arr[l]
            rdist=arr[r]-x
            if ldist>rdist:
                l=l+1
            else:
                r=r-1
        for i in range(l,r+1):
            ans.append(arr[i])
        return ans
            
        
       
              
        
            
        
