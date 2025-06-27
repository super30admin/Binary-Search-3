"""
Problem: findClosestElements
approach: find the start index for the k window and move the start index (mid) depending the distance of mid 
with x and  end index (start + k) with x.
t.c. => O(n)
s.c. => O(1)
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        l, r = 0, n - k
        
        while l < r:
            mid = l + (r - l)//2
            distL = (x - arr[mid])
            distR = (arr[mid + k] - x)

            if distL <= distR:
                r = mid
            else:
                l = mid + 1
        return arr[l : l + k]