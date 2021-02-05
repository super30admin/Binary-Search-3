# Time Complexity : O(log n + k) where n is length of array and k is the number of closest element
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I find closest lower element to target element and then use 2 pointers to populate a list
# and then return list as array

from collections import deque
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        idx = self.bin_search(arr, x)
        left = idx
        right = idx + 1
        q = deque()
        for i in range(k):
            left_d = abs(arr[left]-x) if left >=0 else math.inf
            right_d = abs(arr[right]-x) if right < len(arr) else math.inf
            if left_d <= right_d:
                q.appendleft(arr[left])
                left -= 1
            else:
                q.append(arr[right])
                right += 1

        return list(q)
    
    def bin_search(self, arr ,x):
        start = 0
        end = len(arr)-1
        
        while start < end:
            mid = start + ((end - start) // 2) + 1
            if arr[mid] < x:
                start = mid
            elif arr[mid] > x:
                end = mid - 1
            else:
                return mid
        
        return start