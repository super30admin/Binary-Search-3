# Space Complexity: O(N)
# Time Complexity: O(NlogK)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        heap = []

        for i, ele in enumerate(arr): 
            dist = abs(ele - x)

            if len(heap) >= k:
                heapq.heappushpop(heap, (-dist, -i, ele))
            else:
                heapq.heappush(heap, (-dist, -i, ele))

        res = []

        while heap:
            _, _, ele = heapq.heappop(heap)
            res.append(ele)
        return sorted(res)
