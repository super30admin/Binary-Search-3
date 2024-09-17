# APPROACH 1: MAX HEAP
# Time Complexity : O(n lg k), n: len(arr) and k: size of heap
# Space Complexity : O(k) - space of heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Maintain a max heap of size k where the key is abs(element - x)
# 2. If heap size is k and the current difference same as the key of the top element, ignore the current element (as preference for lesser valued element when difference is same)
# 3. If heap size is more than k, then pop from it
# 4. sort the final heap elements and return it.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        if arr is None:
            return None
        
        max_heap = []
        for num in arr:
            
            diff = abs(num - x)
            if len(max_heap) == k and -1 * diff == max_heap[0][0]:
                continue
                    
            heapq.heappush(max_heap, (-1 * diff, num))
            if len(max_heap) > k:
                heapq.heappop(max_heap)
                
        
        result = [element[1] for element in max_heap]
        result.sort()
        return result
        
        
        

# APPROACH 2 : TWO POINTER 
# Time Complexity : O(n), n: len(arr) actually -> O(n - k) for 2 ptr and O(k) for extracting the subarray
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. 2 pointers low -> 0 and high -> len(arr) - 1
# 2. Keep going till I get a window of size k. 
# 3. If difference at low is high, increement low. Similarly for high. If difference is same, decreement high (preference for lower elements)
# 4. Return the elements within the window.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        if arr is None:
            return None
        
        low, high = 0, len(arr) - 1
        
        while high - low + 1 > k:
            
            if abs(arr[high] - x) == abs(arr[low] - x):
                high -= 1
            elif abs(arr[high] - x) < abs(arr[low] - x):
                low += 1
            elif abs(arr[high] - x) > abs(arr[low] - x):
                high -= 1
                
        return arr[low : low + k]
        
        

# APPROACH 3: BINARY SEARCH 
# Time Complexity : O((n - k) lg n), n: len(arr) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do binary search to search for the correct start position of the window. so start -> 0 and end -> len(arr) - k (as we need a window of size k).
# 2. Keep checking the difference with element at mid and element at mid + k. (these are potential positions for new mid)
# 3. Move towards the side of lower difference. 
# 4. if elements at mid and mid + k is same move towards right half of arr
# 5. return arr[low : low + k], as low is now at right position

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        if arr is None:
            return None
        
        low, high = 0, len(arr) - k
        
        while low < high:
            mid = low + (high - low) // 2
            
            if arr[mid] == arr[mid + k]:
                low = mid + 1
            elif abs(arr[mid] - x) == abs(arr[mid + k] - x):
                high = mid
            elif abs(arr[mid] - x) > abs(arr[mid + k] - x):
                low = mid + 1
            elif abs(arr[mid] - x) < abs(arr[mid + k] - x):
                high = mid
                
        return arr[low : low + k]
