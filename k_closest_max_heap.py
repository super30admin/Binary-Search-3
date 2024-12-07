"Time Complexity is O(N log K)"
"Space Complexity is O(K)"


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        max_heap = []
        result = []

        for i in range(len(arr)):
            heappush(max_heap, (-(abs(arr[i] - x)), -arr[i]))

            if len(max_heap) > k:
                heappop(max_heap)
        
        while max_heap:
            result.append(-heappop(max_heap)[1])
        
        return sorted(result)