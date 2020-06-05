"""
// Time Complexity :O(log n) for binary search/ O(n) for two pointer
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA
// Explanation:
   binary search -> O(log n), S = O(n) for storing result
   binary search fails for duplicate records in array. check pointer          solution
   window i.e high - low = k
   calculate leftdistance and rightdistance
   update the left and high point accordingly

   pointer solution:T = O(n),S = O(n) for storing result
   use low and high pointer
   calculate the leftDistance and rightDistance by subtracting low and high from x
   compare leftDistance and rightDistance and updae low/ high
   accordingly
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # two pointer solution
        result = []
        if arr is None or len(arr) == 0:
            return result
        low = 0
        high = len(arr) - 1

        while((high - low + 1) > k):
            leftDistance = abs(x - arr[low])
            rightDistance = abs(x-arr[high])
            if leftDistance > rightDistance:
                low += 1
            else:
                high -= 1

        for i in range(low,low+k):
            result.append(arr[i])
        return result
"""
        # binary solution
        low = 0
        high = len(arr) -k
        result = []
        while low < high:
            mid = int((low+high)/2)
            leftDistance = abs(arr[mid]-x)
            rightDistance = abs(arr[mid+k] -x)
            if leftDistance > rightDistance :
                low = mid + 1
            else:
                high = mid

        for i in range(low,low+k):
            result.append(arr[i])
        return result
"""
