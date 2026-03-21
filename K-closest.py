class TwoPointerSolution:
# 2 pointers:
# TC: O(n-k) + O(k)
# SC: O(1)
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr)-1

        while right-left+1 != k:
            left_distance = abs(arr[left] - x)
            right_distance = abs(arr[right] - x)

            if left_distance <= right_distance:
                right -=1
            else:
                left += 1
        
        result = arr[left:right+1]

        return result
    
class BinarySearchSolution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # binary search
        low = 0
        high = len(arr)

        while low < high:
            mid = (low+high)//2
            if arr[mid] < x:
                low = mid+1
            else:
                high = mid
        # mid is starting point now
        left = low-1
        right = low 
        while right - left - 1 < k: # 1-0+1 = 2 !=4
            if left >= 0 and right < len(arr):
                right_distance = abs(arr[right] - x)
                left_distance = abs(arr[left] - x)
                if left_distance <= right_distance:
                    left -= 1
                else:
                    right += 1
            elif left >= 0:
                left -= 1
            else:
                right += 1
        
        res = arr[left + 1:right]

        return res

from heapq import heappush, heappop
class heapSolution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = []

        for idx, num in enumerate(arr):
            distance = abs(x-num)
            heappush(heap,(-distance, -num))
            if len(heap) > k:
                heappop(heap)
        
        result = []

        while heap:
            result.append(-heappop(heap)[1])
        
        return sorted(result)