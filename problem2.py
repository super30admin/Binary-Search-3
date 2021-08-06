import heapq
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #Approach 4, find left most closest value, Time O(logn)
        low=0
        high=len(arr)-k
        result=[]
        closest=0
        #closest binary search,we are starting high with k elemnt
        #leftmost boundary
        while(low<high):
            mid=low+(high-low)//2
            dismid=x-arr[mid]
            if (mid+k)>len(arr):break
            dismidk=arr[mid+k]-x
            
            if dismid<=dismidk:
                high=mid
            else:
                low=mid+1
        
        for i in range(low,low+k):
            result.append(arr[i])
        return result
        
#         #Approach 3 binary search, find closest value and then expand Time O(logn+n/2)
#         low=0
#         high=len(arr)-1
#         result=[]
#         closest=0
#         #closest binary search
#         while(low<high):
#             mid=(low+high)//2
#             disl=x-arr[low]
#             dish=arr[high]-x
#             if disl<=dish:
#                 high-=1
#             else:
#                 low+=1
#         p1=low-1
#         p2=low+1
        
#         result.append(arr[low])
#         count=k-1
#         while(p1>=0 and p2<len(arr) and count>0):
#             count-=1
#             if abs(arr[p1]-x)==abs(arr[p2]-x):
#                 result.append(arr[p1])
#                 p1-=1
#             elif abs(arr[p1]-x)>abs(arr[p2]-x):
#                 result.append(arr[p2])
#                 p2+=1
#             elif abs(arr[p1]-x)<abs(arr[p2]-x):
#                 result.append(arr[p1])
#                 p1-=1
#         while( p2<len(arr) and count>0):
            
#             count-=1
#             result.append(arr[p2])
#             p2+=1
#         while( p1>=0 and count>0):
#             count-=1
#             result.append(arr[p1])
#             p1-=1
          
#         return sorted(result)
            
            
        
        
        
#         #approach 2, with heap Time O(nlogk)worst O(nlogn)
#         heap=[]
#         for v in arr:
#             heappush(heap,(abs(v-x),v))
                
#         result=[]
#         while(len(heap)>(len(arr)-k)):
#             result.append(heappop(heap)[1])  
#         result.sort()
#         return result[:k]
        
        
        
        
#         #approach 1 brute force sort Time O(nlogn)
#         def myFunc(e):
            
#             return abs(e-x)
#         arr=sorted(arr,key=myFunc)
#         print(arr)
#         return sorted(arr[:k])
        
