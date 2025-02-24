# Time complexity - O(log(n-k) + k) # doing BS and giving out k elements
# Space complexity - O(1)

# Approach - Do Binary Search on first (n-k) elements, we're doing this to find the starting element of our
# output. Return arr[l:l+k] (We cannot do mid:mid+k in case the n == 1, because then l==h==0 and we never
# enter while loop, so no mid variable) 

from typing import List
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l, h = 0, len(arr) - k

        while l < h:
            mid = l + ((h-l)//2)
            dists = x - arr[mid]
            diste = arr[mid+k] - x
            if dists > diste:
                l = mid + 1
            else:
                h = mid
        return arr[l:l+k]