# Time Complexity : O(Log(n))
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        low = 0
        high = len(arr) - k

        while low < high:
            mid = int(low  + (high-low)/2)

            distA = x-arr[(mid)]
            distB = arr[(mid+k)] - x

            if distA > distB:
                low = mid+1
            else:
                high = mid

        result = []
        for i in range(0,k):
            result.append(arr[low+i])

        return result


