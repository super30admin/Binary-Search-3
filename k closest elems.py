# TC: O(logn)
# SC: O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low = 0
        high = n - k

        while low < high:
            mid = (low+high)//2
            disS = x - arr[mid]
            disE = arr[mid+k] - x

            if disS > disE:
                low = mid+1
            else:
                high = mid
        
        res = []
        for i in range(low, low+k):
            res.append(arr[i])
        
        return res
