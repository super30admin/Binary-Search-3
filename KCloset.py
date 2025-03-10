class Solution:
    # Binary Search 
    # TC - O(log(n-k)) + O(k)
    # SC - O(1)
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low, high = 0, len(arr) - k
        while low < high:
            mid = low + (high - low) // 2
            if abs(x - arr[mid]) > abs(x - arr[mid + k]):
                low = mid + 1
            else:
                high = mid
        return arr[low:low + k]
    
    # Two Pointer 
    # TC - O(n)
    # SC - O(1)
    def findClosestElementsTwoPointer(self, arr: List[int], k: int, x: int) -> List[int]:
        low, high = 0, len(arr) - 1
        while high - low + 1 > k:
            if abs(x - arr[low]) > abs(x - arr[high]):
                low += 1
            else:
                high -= 1
        return arr[low:low + k]
    # Heap Solution
    # TC - O(nlogn)
    # SC -  O(n)  
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        minHeap = []
        result = []
        for i in range(len(arr)):
            distance = abs(x-arr[i])
            heapq.heappush(minHeap,(distance,arr[i]))
        for i in range(k):
            distance, elem = heapq.heappop(minHeap)
            result.append(elem)
        result.sort()     
        return result  
