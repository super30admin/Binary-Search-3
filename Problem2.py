'''

Time Complexity : O(log (n-k))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Using a sliding window approach, we can find a spot where the distance is minimum and return that list

'''

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l,r = 0,len(arr)-k

        while l < r:
            mid = (l + r) // 2

            if x - arr[mid] > arr[mid+k] - x:
                l = mid + 1
            else:
                r = mid

        return arr[l:l+k]
