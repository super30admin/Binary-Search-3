import heapq as heap
'''Time Complexity: O(nlog)
Space Complexity: O(n)'''
class Comparator:
    def __init__(self,val, diff):
        self.val=val
        self.diff=diff
    
    def __lt__(self, other):
        #If the distance is same go for the lower value
        if self.diff==other.diff:
            return self.val > other.val
        else:
            return self.diff > other.diff
class Solution(object):
            
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        
        maxheap=[]
        for i in range(len(arr)):
            heap.heappush(maxheap,Comparator(arr[i], abs(x-arr[i])))
            #Discarding large distance nodes
            if len(maxheap) > k:
                heap.heappop(maxheap)
            
        result=[]
        while len(maxheap)!=0:
            result.append(heap.heappop(maxheap).val)
        return sorted(result)
        
