# Use Max Heap. Put the values and their abs distance to x in the heap
# Maintain heap size of k and pop out elements with max distance if heap starts growing
# Ultimately return heap values in sorted manner

import heapq as hq
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = []
        for num in arr:
            # push distance of element with x and element both, as -ve value tuple
            # that way we can pop the value(it will pop the minimum -ve value)
            # which gets us a way to use it as a max heap
            hq.heappush(heap, (-1 * abs(x-num), -1* num))
            if len(heap) > k:
                # print(heap)
                hq.heappop(heap)
        # for the result remember to convert negative values to positive again
        return sorted([-1 * item[1] for item in heap])

# Two pointers
# TC O(n-k) as we traverse atmost n-k elements from two ends and close the gap/window
# SC O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l, h = 0, len(arr) - 1
        
        while (h - l+ 1) > k:  # while l and h pointers are k places apart, add +1 to account for 0 based indices
            if abs(arr[l] - x) <= abs(arr[h] - x): # if dist is same from both ends or higher on right pointer, decremeant h
                h -=1
            else:
                l += 1
        # return l:h+1 to account for fact that end index is not inclusive in python
        return arr[l:h+1]


# binary search
# TC O(log(n-k))
# SC O(1)


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        """
        arr = [1,2,3,4,5]
               0,1,2,3,4
        k= 4
        x= 3
        TC O(log(n-k))
        SC O(1)
        """
        l, h = 0, len(arr) - k  # 0, 1
        
        while l < h: # 0 1 -> 0 0 - > false
            mid = l + (h-l)//2 # 0 + (1-0)//2 = 0 
            # value at arr[mid] is greater and we don't want that in result
            if x - arr[mid] > arr[mid+k] - x:  # 3-arr[mid]=3-1=2. 5-3 = 2 - False
                l = mid + 1
            else:
                h = mid # 0
        return arr[l:l+k]  # arr[0:0+4] = arr[0:4]


