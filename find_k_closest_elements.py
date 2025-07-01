from typing import List, Optional
class Solution:

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        """
        TC: O(log(n-k)) ; to find the start index of range
        AS: O(k)
        """
        # Binary Search to find the start index of the range
        low = 0
        high = len(arr) - k # last possible value of k 
        result = []

        while (low < high):

            mid = low + (high-low)//2
            # One extra element to ensure that we go away from high if start dist and end dist are equal
            end = mid + k 

            distS = x - arr[mid]
            distE = arr[mid+k] - x

            # SeeSaw titlted towards distS, move low pointer to balance the seesaw
            if distS > distE:
                low = mid + 1
            else:  # distS <= distE
                high = mid

        for i in range(low, low+k):
            result.append(arr[i])

        return result

    ## Two Pointer Solution
    # def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
    #     """
    #     TC: O(n)
    #     AS: O(1)

    #     """
    #     low = 0
    #     high = len(arr)-1
    #     result = []

    #     while (high - low) >= k:
    #         distL = x - arr[low]
    #         distH = arr[high] - x

    #         if distH >= distL:
    #             high -= 1
    #         else: # distH < distL
    #             low += 1


    #     for i in range(low, high+1):
    #         result.append(arr[i])

    #     return result

    ## Heap Solution
    # import heapq
    # def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
    #     """
    #     TC: O(n log k)
    #     AS: O(k)
    #     """
    #     max_heap = [] # need the closest element, so meaning max should be ignored
    #     result = []

    #     for num in arr:
    #         heapq.heappush(max_heap, (-abs(x-num), -num))

    #         if len(max_heap) > k:
    #             heapq.heappop(max_heap)
            
    #     for i in max_heap:
    #         result.append(-i[1])

    #     result.sort()
    #     return result