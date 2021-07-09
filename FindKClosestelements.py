class Solution:
    
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        """modified binary search
        Time complexity-O(log(n-k)) as doing binary search on n-k elements
        Space complexity-O(1)"""
        result=[]
        start=0
        end=len(arr)-k
        while start<end:
            mid=start+(end-start)//2
            print(start, mid, mid+k, end)
            dl = x - arr[mid]
            dr = arr[mid+k]-x
            # print(arr[mid],dl, dr)
            if dl > dr:
                start=mid+1
            else:
                end=mid
            # print(start, mid)
        for i in range(start,start+k):
            result.append(arr[i])
        return result
        
        
        
        
        """nearest binary search for target and then use 2 pointers to find k elements-->best used when k is very less value
        Time complexity-O(log(n))(binary search)+O(k)(t2 pointers)+O(klog(k))(sort the final result)
        Space complexity-O(1)"""
#         mid=self.bst(arr, k, x)
#         result=self.findkele(mid, arr, k, x)
#         return result
        
#     def findkele(self, mid, arr, k, x):
#         result=[]
#         result.append(arr[mid])
#         start=mid-1
#         end=mid+1
#         length=k-1
#         while length!=0 and end<len(arr) and start>=0:
#             print(arr[start]-x,x-arr[end])
#             if (x-arr[start])<=(arr[end]-x):
#                 result.append(arr[start])
#                 start-=1
#             elif (x-arr[start])>(arr[end]-x):
#                 result.append(arr[end])
#                 end+=1
#             length-=1
#         while length!=0:
#             if start>=0:
#                 result.append(arr[start])
#                 start-=1
#             elif end<len(arr):
#                 result.append(arr[end])
#                 end+=1
#             length-=1
#         result.sort()
#         return result
        
#     def bst(self, arr, k, x):
#         start=0
#         end=len(arr)-1
#         if x<=arr[start]:
#             return start
#         if x>=arr[end]:
#             return end
#         while start<end:
#             mid=start+(end-start)//2
#             if x==arr[mid]:
#                 return mid
#             elif x<arr[mid]:
#                 if mid>0 and x>arr[mid-1]:
#                     if (x-arr[mid-1])<(arr[mid]-x):
#                         return mid-1
#                     else:
#                         return mid
#                 else:
#                     end=mid-1
#             else:
#                 if mid<len(arr)-1 and x<arr[mid+1]:
#                     if (x-arr[mid])<=(arr[mid+1]-x):
#                         return mid
#                     else:
#                         return mid+1
#                 else:
#                     start=mid+1
#         return mid
                    
                
            
            
        """2 pointers solution
        Time complexity-O(n-k)
        Space complexity-O(1)"""
        # result=[]
        # start=0
        # end=len(arr)-1
        # while end-start+1>k:
        #     diffstart=(x-arr[start])
        #     diffend=(arr[end]-x)
        #     if diffstart>diffend:
        #         start+=1
        #     else:
        #         end-=1
        # for i in range(start, end+1):
        #     result.append(arr[i])
        # return result
        """Priority Queue implementation
        Time complexity-O(nlog(k))
        Space complexity-O(k)"""
        # result=[]
        # out=[]
        # for i in range(len(arr)):
        #     heapq.heappush(result, (-1*abs(arr[i]-x), -1*arr[i]))
        #     if len(result)>k:
        #         heapq.heappop(result)
        # print(result)
        # for i in range(len(result)):
        #     out.append(-1*result[i][1])
        # out.sort()
        # return out
                           
            
        """Time complexity-O(nlog(n)) as we are iterating over the whole array and then sorting it based on difference between element and x
        Space complexity-O(1)"""
        # result=[]            
        # for i in range(len(arr)):
        #     arr[i]=(arr[i],abs(arr[i]-x))
        # arr=sorted(arr, key = lambda x: x[1])
        # for i in range(0, k):
        #     result.append(arr[i][0])
        # result.sort()
        # return result
        