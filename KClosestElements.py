#Code using the max heap and then sorting according to the value of 'a'
#TC: O(nlogk)
class Node:
    def __init__(self,a,b):
        self.a=a
        self.b=b
    def __lt__(self,other):
        if self.b==other.b:
            return other.a<self.a
        return other.b<self.b
from heapq import heappush as push
from heapq import heappop as pop
class Solution(object):
    def findClosestElements(self, arr, k, x):
    
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        maxHeapK = []
        for i in range(len(arr)):
            n=Node(arr[i],abs(x-arr[i]))
            push(maxHeapK,n)
            if (len(maxHeapK) > k):
                pop(maxHeapK)
        result=[]
        maxHeapK=sorted(maxHeapK,key=lambda x:(x.a))
        for h in maxHeapK:
            result.append(h.a)
        return result

#code using two pointers
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


'''
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
'''
        