#Time Complexity: O(logn)
#Space Complexity: O(1)
#Successfully ran on leetcode

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr)-k
        while low<high:
            mid = (low+high)//2
            start = (x-arr[mid])
            end = (arr[mid+k]-x)
            if start>end:
                low = mid+1
            else:
                high = mid
        return arr[low:low+k]
    
        