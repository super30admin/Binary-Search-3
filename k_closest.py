# Time complexity: O(log(n - k)), where n is the length of the array.
# Space complexity: O(1)

class Solution:
    def findClosestElements(self, arr, k, x):
        left = 0
        right = len(arr) - k
        while left < right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left + k]


# Time complexity: O(n log k) for the heap approach, where n is the length of the array.
# Space complexity: O(k)

import heapq

class Solution:
    def findClosestElements(self, arr, k, x):
        # Use a max heap to store the k closest elements
        max_heap = []
        for num in arr:
            # Calculate the distance and push it into the heap
            # If the heap size exceeds k, pop the largest element
            heapq.heappush(max_heap, (-abs(num - x), -num))
            if len(max_heap) > k:
                heapq.heappop(max_heap)
        
        # Extract the k closest elements and sort them
        result = [-num for _, num in max_heap]
        return sorted(result)

