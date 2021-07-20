import heapq


class Solution:
    # approach 1: distance from each element
    """
    1. get the distance of x from each element and sort by distance
    2. take the first k element, sort them by value

    TC: O((n log n) + (k log k))
    SC: O(n)

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []

        # get the dsiatnce into the sam array
        for i, num in enumerate(arr):
            arr[i] = (abs(num - x), num)

        arr.sort() # n log n

        for i in range(k):
            result.append(arr[i][1])

        result.sort() # k log k

        return result
    """

    # approach 2: using max heap
    """
    TC: O(n log k + k log k)
    SC: O(k)

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        pri_q = []
        heapify(pri_q)

        result = []

        for i in range(len(arr)):
            heappush(pri_q, (-abs(x-arr[i]), -arr[i]))
            if len(pri_q) > k:
                heappop(pri_q)

        for _ in range(k):
            result.append(-heappop(pri_q)[1])

        result.sort() # k log k 

        return result
    """

    # approach 3: Two pointers
    """
    1) have two pointers at each end
    2) narrow down your range to k based on the distance of each element from x
    3) once you have the range on indices, push the elements to output list

    TC: O(n - k)
    SC: O(1)

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - 1
        result = []

        while (high - low + 1 > k): # O(n - k)
            dist_low = x - arr[low]
            dist_high = arr[high] - x
            if dist_low > dist_high:
                low += 1
            else:
                high -= 1

        for i in range(low, high+1): # O(k)
            result.append(arr[i])

        return result
    """
    1, 2, 3, 4, 5

    # approach 4: nearest binary search
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - 1
        result = []

        while (low < high):  # nearest binary search
            mid = low + (high - low) // 2
            if arr[mid] >= x:
                high = mid
            else:
                low = mid + 1

