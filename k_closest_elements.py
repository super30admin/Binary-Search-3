# Both solutions run on Leetcode
        # Solution 1 using Two pointers 
              # Runtime - O(n)
              # Memory - O(1)
        # Solution 2 using Binary search
              # Runtime - O(logn)
              # Memory - O(1)


# Solution 1

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr:
            return []
        low = 0
        high = len(arr)-1
        while (high - low + 1) > k:
            diff_l = abs(arr[low] - x)
            diff_r = abs(arr[high] - x)
            if diff_l < diff_r:
                high -= 1
            elif diff_l > diff_r:
                low += 1
            else:
                high -= 1
        return arr[low:high+1]
        


# Solution 2

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr:
            return []
        low = 0
        high = len(arr) - k
        while low < high:
            mid = low + (high - low)//2
            diff1 = abs(arr[mid] - x)
            diff2 = abs(arr[mid + k] - x)
            if diff1 > diff2:
                low = mid +1
            else:
                high = mid
                
        return arr[low:low+k]
