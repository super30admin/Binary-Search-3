class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low = 0 
        high = n - k
        result = []
        while low < high:
            mid = low + (high - low)//2
            distS = x - arr[mid]
            distE = arr[mid+k] - x
            if distS > distE:
                low = mid+1
            else:
                high = mid
        
        for i in range(low, low+k):
            result.append(arr[i])
        
        return result