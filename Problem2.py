# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We use binary search to find the starting index of the range. 
# During every iteration we ensure that we are moving towards the direction that gives us a closer range.
# We also handle the cases where the boundaries of the range either lie in the same side or different sides, but have the same absolute distances
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l, h = 0, len(arr)-k
        while l<h:
            mid = l + (h-l)//2
            distS = abs(x - arr[mid])
            distE = abs(x - arr[mid+k])
            if distS > distE:
                l = mid + 1
            elif distS < distE:
                h = mid
            else:
                if arr[mid] >= x:
                    h = mid
                elif arr[mid+k] <= x:
                    l = mid + 1
                elif arr[mid] < x and arr[mid+k] > x:
                    h = mid

        return arr[l:l+k]