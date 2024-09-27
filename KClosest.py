# Time Complexity : Add - O(log N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. using 2 pointers to find the window constituting k elements
2. Whichever side has gretaer distance from x, we move away from it.
'''

class Solution1:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        if not arr and len(arr) < 1:
            return
        
        low = 0
        high = len(arr)-1
        
        while high >= low and high - low > k-1:
            
            distL = abs(x - arr[low])
            distR = abs(x - arr[high])
            
            if distL > distR:
                low += 1
            
            elif distL <= distR:
                high -= 1
                
        return arr[low:high+1]


#Solution2

# Time Complexity : Add - O(nlogK)
# Space Complexity :O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Maintain a Max heap using custom comaparator such that the maximum distance element and right most is
   at top

2. As the size becomes > K, pop from the heap. 
3 The remaining elments are the result
'''

from heapq import heappush
from heapq import heappop as pop


class MyObject:
    
    def __init__(self, diff, val):
        
        self.diff = diff
        self.val = val
        
    def __lt__(self, other):
        
        if self.diff > other.diff or (self.diff == other.diff and self.val > other.val):
            return True
        
        return False
        

    
class Solution2:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        if not arr and len(arr) < 1:
            return
        
        heap_list = []
        for i in arr:
            heappush(heap_list, MyObject(abs(x-i), i))
            if len(heap_list) > k:
                pop(heap_list)
                
            
        result = []
        while len(heap_list) > 0:
            x = pop(heap_list).val
            result.append(x)
            
        return sorted(result)