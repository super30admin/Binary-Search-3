'''
1. Our goal is to find the element closest to x. We can find it in the most optimal way by using binary search with offset as k.
2. Maintain two pointers l and r, to find atleast k elements close to x, the right pointer must be atleast at n-k distance. 
3. If the element is close to mid than mid + k, then move the right pointer to mid, else move the left pointer to mid + 1.

TC: O(log n)
SC: O(1)
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        n = len(arr)
        if n == k:
            return arr
        
        l = 0
        r = n - k

        while l < r:
            mid = (l + r) // 2
            if x - arr[mid] > arr[mid + k] - x:
                l = mid + 1
            else:
                r = mid
        
        return arr[l:l+k]




        