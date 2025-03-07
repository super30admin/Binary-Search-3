from typing import List
import heapq
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # Using Binary search
        low, high = 0, len(arr) - k
        while low < high:
            mid = (low + high) // 2
            disS = x - arr[mid]  # distance between x and arr[mid]
            disE = arr[mid + k] - x  # distance between arr[mid + k] and x
            if disS > disE:
                low = mid + 1  # Move to the right
            else:
                high = mid  # Stay or move to the left
        return arr[low:low + k]

        # two pointers apporach 
        '''
        left, right = 0, len(arr)

        while right - left > k:
            if abs(arr[right - 1] - x) >= abs(arr[left] - x):
                right -= 1
            else:
                left += 1

        return arr[left:right]
        '''
        # Heap based approach
        '''
        result=[]
        for num in arr:
            heapq.heappush(result,(-abs(num -x),-num))
            if len(result)>k:
                heapq.heappop(result)
        
        return sorted(-num for _,num in result)

'''
# if the k is small using heapq is best  or else use two pointers


