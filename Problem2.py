# https://leetcode.com/problems/find-k-closest-elements/

# Heapsort logic => Idea is to use maxheap, so that we can keep the k min distance elements in the heap by eliminating rest of the elements
# and put those elements into a new array
# TC: O(n log k)
# SC: O(k)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        pq = []
        for i in range(len(arr)):
            dist = abs(x - arr[i])
            heapq.heappush(pq, (-dist, -arr[i]))
            if len(pq) > k:
                heapq.heappop(pq)

        result = [-item[1] for item in pq]
        result.sort()
        return result
    
# Two pointer approach
# TC: O(n-k) + O(k)
# SC: O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res = []

        left, right = 0, len(arr) - 1

        while right - left >= k:
            distR = abs(x-arr[right])
            distL = abs(x-arr[left])

            if distL > distR:
                left += 1
            else:
                right -= 1

        for i in range(left, right+1):
            res.append(arr[i])

        return res
            
