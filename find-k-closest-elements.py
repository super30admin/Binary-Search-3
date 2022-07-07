class comp:
    def __init__(self,a:int,b:int):
        self.a=a
        self.b=b
    def __lt__(self,other):
        if self.b==other.b:
            return other.a<self.a
        return other.b<self.b
# using priority queue
# TC: O(n(log(k)))
# SC: O(k)
class Solution:
    # def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
    #     from heapq import heappush as push
    #     from heapq import heappop as pop
    #     heap=[]
    #     for n in arr:
    #         push(heap,comp(n,abs(n-x)))
    #         if len(heap)>k:
    #             pop(heap)
    #     heap=sorted(heap, key = lambda x: (x.a))
    #     result=[]
    #     for h in heap:
    #         result.append(h.a)
    #     return result
    
    
# Two pointer approach
# TC: O(n-k)
# SC: O(1)
    # def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
    #     l=0
    #     r=len(arr)-1
    #     while r-l+1>k:
    #         ldif=abs(x-arr[l])
    #         rdif=abs(x-arr[r])
    #         print(ldif,rdif)
    #         if ldif>rdif:
    #             l+=1
    #         else:
    #             r-=1
    #     return arr[l:r+1]
    
# Binary Search
# TC: O(log(n-k))
# SC: O(1)
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l=0
        r=len(arr)-k
        while l<r:
            mid=l+(r-l)//2
            ldif=x-arr[mid]
            rdif=arr[mid+k] - x
            print(ldif,rdif)
            if ldif>rdif:
                l=mid+1
            else:
                r=mid
            
        return arr[l:l+k]