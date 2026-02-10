class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        heap=[]
        result=[]

        for i in range(len(arr)):
            dist=abs(arr[i]-x)
            heapq.heappush(heap,(-dist,-arr[i]))
            if len(heap)>k:
                heapq.heappop(heap)

        
        for item in heap:
            result.append(-item[1])
        result.sort()
        return result