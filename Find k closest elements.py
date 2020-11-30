# Time:- O(n)
# Space:- O(1)
# Approach:- Binary Search the number<=target and use two pointer and a deque to maintain sorted order. Compare left and right pointer values decrement the left
# pointer if the left pointer value is more closer to the target than the right append left the left value to a queue to maintain sorted order. Otherwise increment right and append right to the queue
from bisect import bisect_left
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        def bs(left,right,x):
            while(left<right):
                mid=(left+right)//2
                if arr[mid]==x:
                    return mid
                if arr[mid]<x:
                    left=mid+1
                else:
                    right=mid-1
            return left-1
            
        left=bs(0,len(arr)-1,x)
        right=left+1
        res=collections.deque([])
        while(left>=0 and right<len(arr) and len(res)<k):
            if x-arr[left]<=arr[right]-x:
                # maitaining sorted order
                res.appendleft(arr[left])
                left-=1
            else:
                # maintaining sorted order
                res.append(arr[right])
                right+=1
        # we breached right boundary but we still have elements to put in the list
        while(left>=0 and len(res)<k):
            res.appendleft(arr[left])
            left-=1
        # we breached left boundary but we still have elements to put in the list
        while(right<len(arr) and len(res)<k):
            res.append(arr[right])
            right+=1
        return res