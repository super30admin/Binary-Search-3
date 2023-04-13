# Using two pointer solution
# Time Complexity - O(n)
# Space Complexity - O(1)


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        l = 0 
        r = n - 1 
        res = []
        while r - l + 1 > k:
            distl = abs(arr[l] - x)
            distr = abs(arr[r] - x)
            if distl > distr:
                l += 1 
            else:
                r -= 1 
        
        for i in range(l, r + 1):
            res.append(arr[i])
        return res
# Using binary search
# Time Complexity - O(logn)
# Space Complexity - O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        start = 0
        end = n - k 
        res = []
        while start < end:
            mid = start + (end - start) // 2 
            distS = x - arr[mid]
            distE = arr[mid+k] - x 

            if distS <= distE: 
                end = mid 
            else:
                start = mid + 1 

        for i in range(start, start+k):
            res.append(arr[i])

        return res

