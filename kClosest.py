# TC: O(log(n - k))
# SC: O(k)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low=0
        high=len(arr)-k
        while low<high:
            mid=(low+high)//2

            # is left end of current window farther from x than right end of next window ?
            if x-arr[mid]>arr[mid+k]-x:
                #yes, then shift right
                low=mid+1
            else:
                #no, then shift left (to check if theres a better one) or retain current window 
                high=mid
        
        return arr[low:low+k]