'''
    Time Complexity: O(nlogk)
    Space Complexity: O(k)
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = []

        for num in arr:
            distance = abs(x - num)
            heapq.heappush(heap, (-distance, -num))

            if len(heap) > k:
                heapq.heappop(heap)

        result = sorted([-x[1] for x in heap])

        return result
