class Solution:

    #Time Complexity : O(Log(n-k))
    #Space Complexity: O(1)
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr:
            return arr
        l = 0
        r = len((arr)) - k
        while l < r:
            mid = (l + r) // 2
            dl = x - arr[mid]
            dr = arr[mid + k] - x
            if dl > dr:
                l += 1
            else:
                r -= 1
        return arr[l:l + k]

    # Time Complexity : O(n)+O(K)
    # Space Complexity: O(1)
    def findClosestElements2Ptr(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr:
            return arr
        l = 0
        r = len((arr)) - 1
        while (r - l + 1 > k):
            distL = abs(x - arr[l])
            distR = abs(x - arr[r])
            if distL > distR:
                l += 1
            else:
                r -= 1
        return arr[l:r + 1]

    # Time Complexity : O(nLog(k))+O(NLog(N))
    # Space Complexity: O(k)
    def findClosestElementsHeap(self, arr: List[int], k: int, x: int) -> List[int]:
        maxHeap = []

        for i in range(k):
            heapq.heappush(maxHeap, (-abs(x - arr[i]), i))

        # print(maxHeap)

        for i in range(k, len(arr)):
            diff = -(abs(x - arr[i]))
            if -maxHeap[0][0] > -diff:
                heapq.heappop(maxHeap)
                heapq.heappush(maxHeap, (diff, i))
            elif -maxHeap[0][0] == -diff:
                continue
        # print(maxHeap)
        result = []
        while maxHeap:
            result.append(arr[heapq.heappop(maxHeap)[1]])
        return sorted(result)

