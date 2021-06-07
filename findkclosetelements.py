def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
    if arr is None: return -1
    heap = []
    result = []
    for element in arr:
        heapq.heappush(heap, (-1 * (element - x), element))

        if heap.__len__() > k:
            heapq.heappop(heap)

    while heap.__len__() > 0:
        key, val = heapq.heappop(heap)

        print(key, val)

        result.append(val)

    return result

    # O(nlogk)
    # O(n)
    # Heap for maintaining the distane


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if arr is None: return -1
        low, high = 0, len(arr) - k
        result = []
        while low < high:
            mid = low + (high - low) // 2
            disf = x - arr[mid]
            disl = arr[mid + k] - x

            if disf > disl:
                low = mid + 1
            else:
                high = mid
        for element in range(low, low + k):
            result.append(arr[element])

        return result

        # O(log(n-k))
        # O(1)
        # cutomized BS