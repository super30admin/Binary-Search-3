from Queue import PriorityQueue
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        #modified binary search for range: O(log(n-k) + k)
        l,h = 0,len(arr)-k
        while l<h:
            mid = (l+h)/2
            lDiff =  x - arr[mid]
            rDiff = arr[mid+k]-x
            if lDiff>rDiff:
                l = mid + 1
            else:
                h = mid
        return arr[l:l+k]
        
        #binary search: O(log n + k) TOCOMPLETE
#         l,h = 0,len(arr)-1
#         pos = -1
#         while l<=h:
#             mid = l+h/2
#             diff = arr[mid] - x
#             pos = mid
#             if diff == 0:
#                 break
#             elif diff<0:
#                 l = mid+1
#             else:
#                 h = mid-1
        
#         curK = 1
#         res = [arr[pos]]
#         low,high = pos-1,pos+1
#         while curK < k:
#             res.append(arr[low])
#             curK+=1
#             if curK>k:
#                 break
#             res.append(arr[high])
#             curK += 1
#             if low>=0 and a
        
            
        # two pointer : O(n-k)
        # l,h = 0,len(arr)-1
        # while h-l+1>k:
        #     distH = abs(arr[h] -x)
        #     distL = abs(x - arr[l])
        #     if distL>distH:
        #         l+=1
        #     else:
        #         h-=1
        # return arr[l:l+k]
        
        # #max heap solution: O(nlogk)
        # q = PriorityQueue()
        # for el in arr:
        #     q.put((-1*abs(el-x),-1*el))
        #     if q.qsize()>k:
        #         q.get()
        # res = []
        # while not q.empty():
        #     res.append(-1*q.get()[1])
        # res.sort()
        # return res
        #brute force : O(nlogn)
#         tup_list = []
#         for el in arr:
#             tup_list.append((el,abs(el-x)))
        
#         tup_list.sort(key = lambda x:x[1])
        
#         res = []
#         for el in tup_list[:k]:
#             res.append(el[0])
#         res.sort()
#         return res
            
