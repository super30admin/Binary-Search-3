'''
Time Complexity --> O(nlogn)

Space Complexity -->
O(n) for the list to store the diff and the value and O(n) for the queue
# '''
# from queue import PriorityQueue
# class Solution:
#     def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
#         ls = []
#         for i in range(len(arr)):
#             diff = abs(arr[i]-x)
#             ls.append((diff, arr[i]))
#         print(ls)
#         q = PriorityQueue()
#         for i in ls:
#             diff, val = i[0], i[1]
#             q.put((diff, val))
#         res = []
#         for i in range(k):
#             diff, val = q.get()
#             res.append(val)
#         #print(res)
#         res.sort()
#         return res


'''
Time Complexity --> O(n)
Space Complexity --> O(1)
'''

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #two pointer appraoch
        left = 0
        right = len(arr)-1
        if k==len(arr):
            return arr
        while left<right:
            if abs(x-arr[left])<=abs(x-arr[right]):
                right-=1
            else:
                left+=1
            if (right-left)+1 == k:
                break
        res = []
        for i in range(left, right+1):
            res.append(arr[i])
        return res
            
        