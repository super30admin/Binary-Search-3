# Time complexity: O(nlogk) iterating through the arr(O(n) and then pushing it to heap(logk)
# Space complexity: O(k)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        pq = []
        for num in arr:
            dist = abs(x-num)
            heapq.heappush(pq, (-dist, -num))
            if len(pq) > k:
                heapq.heappop(pq)
        res = []
        while pq:
            res.append(-1 * heapq.heappop(pq)[1])
        res.sort()
        return res


    #Time complexity is O(n) linear and space is O(1) as we only use 2 pointers.
    def findClosestElements2Pointer(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr) - 1

        while (right - left + 1) != k:
            if abs(x - arr[right]) >= abs(x - arr[left]):
                right -= 1
            else:
                left += 1
        result = []
        for i in range(left, right + 1):
            result.append(arr[i])

        return result

    # Time complexity = O(logn + k) logn n for binary search of the start index and then looping through to add the elements into the result. 
    def findClosestElementsBinarySearch(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k

        while (low < high):
            mid = low + (high - low) // 2
            dists = x - arr[mid]
            diste = arr[mid + k] - x
            if (dists <= diste):
                high = mid
            else:
                low = mid + 1

        result = []
        for i in range(low, low + k):
            result.append(arr[i])

        return result