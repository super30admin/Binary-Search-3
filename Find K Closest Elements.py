# time complexity is o(log(n-k)), where n is the size of the input, k is number of closest elements given in input
# space complexity is o(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k 
        while(low < high):
            mid = low + (high - low)//2
            dists = x - arr[mid]
            diste = arr[mid + k] - x
            if(dists > diste):
                low = mid + 1
            else:
                high = mid
        return arr[low : low+k]
        
        
        
#         time complexity is o(n-k), where n is the size of the input
#         space complexity is o(1)
#         low  = 0
#         high = len(arr) - 1
#         while(high - low + 1 > k):
#             ldiff = abs(arr[low] - x)
#             hdiff = abs(arr[high] - x)
#             if(ldiff > hdiff):
#                 low += 1
#             else:
#                 high -= 1
#         return arr[low:high+1]
        
        
        
     
        
# time complexity is o(nlogk) + o(klogk)    
# space is o(n) + o(k)
#         from heapq import heappush
#         from heapq import heappop
#         heap = [] #space is o(k)
#         class DifEl:
#             def __init__(self, dif, el):
#                 self.l = [dif, el]
                
#             def __lt__(self, other):
#                 if(self.l[0] == other.l[0]):
#                     return self.l[1] > other.l[1]
#                 return self.l[0] > other.l[0]
                       
#         # lessthan = lambda x, y : x.l[0] > y.l[0]
#         # DifEl.__lt__ = lessthan
#         for i in arr: #time is o(n)
#             t = DifEl(abs(i-x), i) # space is o(n), creating n objects
#             # if(len(heap) == k and heap[0].l[0] == t.l[0] and heap[0].l[1] < t.l[1]):
#             #     continue
#             heappush(heap, t)
#             if(len(heap) > k): # time is o(log(k))
#                 ll = heappop(heap)
#         res = []
#         while(len(heap) > 0):
#             temp = heappop(heap)
#             res.append(temp.l[1])
#         res.sort() #time is o(klogk)
#         return res
                
        
        
        
        
        
        
          # from heapq import heappush
          # from heapq import heappop
          # heap = []       
        
#         class DifEl:
#             def __init__(self, dif, el):
#                 self.l = [dif, el]
#         lessthan = lambda x, y : x.l[0] > y.l[0]
#         DifEl.__lt__ = lessthan
#         for i in arr:
#             t = DifEl(abs(i-x), i)
#             if(len(heap) == k and heap[0].l[0] == t.l[0] and heap[0].l[1] < t.l[1]):
#                 continue
#             heappush(heap, t)
#             if(len(heap) > k):
#                 ll = heappop(heap)
#                 print(ll.l[1])
#         res = []
#         while(len(heap) > 0):
#             temp = heappop(heap)
#             res.append(temp.l[1])
#         res.sort()
#         return res
                
            
                