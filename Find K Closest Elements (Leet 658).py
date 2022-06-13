# Two Pointers
# Time: O(n-k)
# Space: O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        l = 0
        r = len(arr) - 1
        
        while r - l >= k:
            a = abs(arr[l] - x)
            b = abs(arr[r] - x)
            if a == b:
                r -= 1
            elif a > b:
                l += 1
            else:
                r -= 1
        return arr[l:r+1]




# Max Heap
# Time: O(nlogk) + O(klogk)
# Space: O(k)

import heapq as hq

class cl:
    def __init__(self, val):
        self.val = val
        self.diff = None
    
    def __lt__(self, other):
        if self.diff == other.diff:
            return self.val > other.val
            
        else:
            return self.diff > other.diff

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        heap = list()
        
        for num in arr:
            di = abs(num-x)
            obj = cl(num)
            obj.diff = di
            hq.heappush(heap, obj)
            if len(heap) > k:
                hq.heappop(heap)
        print([[x.val,x.diff] for x in heap])
        res = list()
        for _ in heap:
            res.insert(0,_.val)
        return sorted(res)


# Binary Search for ele (logn)
# find the val or near by val then spread both sides to get the desired output


# Binary Search for range (efficient)
# Time: O(log(n-k))
# Space: O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l = 0
        r =len(arr)-k
        
        
        while l < r:
            m = l + (r-l)//2
            dist_start = x - arr[m]
            dist_last = arr[m+k] - x
            if dist_start > dist_last:
                l = m + 1
            else:
                r = m
            
        return arr[l:l+k]


