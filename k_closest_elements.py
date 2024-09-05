class Solution:
    # Time Complexity = O(log(n-k))
    # USe binary search to find the range of the k elements
    # use mid to find start and end range
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low, high = 0, len(arr) - k
        while (low < high):
            mid = low + (high - low) // 2
            distA = x - arr[mid]
            distB = arr[mid+k] - x
            if (distA <= distB):
                high = mid
            else:
                low = mid + 1
        return arr[low:low+k]
        

