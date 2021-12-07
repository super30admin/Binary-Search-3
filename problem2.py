#Time Complexity : O(log n)
#Space Complexity: O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        lo = 0
        hi = len(arr)-k
        while lo<hi:
            mid = lo+(hi-lo)//2
            if x-arr[mid]>arr[mid+k]-x:
                lo  = mid+1
            else:
                hi = mid
        return arr[lo:lo+k]