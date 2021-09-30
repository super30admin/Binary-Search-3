#Time Complexity : O(log n-k)
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k
        while low<high:
            mid = floor((low+high)/2)
            d_low = x - arr[mid]
            d_high = arr[mid+k] - x
            if d_low > d_high:
                low = mid+1
            else:
                high = mid
        res = []
        for i in range(low, low+k):
            res.append(arr[i])
        return res