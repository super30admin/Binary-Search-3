# Time Complexity :O(log(n-k))
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k
        res = []

        while low < high:
            mid = low + (high-low)//2
            s = x - arr[mid]
            e = arr[mid+k] - x

            if s > e:
                low = mid+1
            else:
                high = mid
        # print(low)
        
        for i in range(k):
            res.append(arr[low+i])

        return res