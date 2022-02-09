'''
TC: O(logn + k)
SC: O(1)
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr:
            return []
        
        if arr[0] >= x:
            return arr[:k]
        if arr[-1] <= x:
            return arr[len(arr) - k:]
        

        low, high = 0, len(arr)
        
        while low < high:
            mid = (low + high) // 2
            if arr[mid] >= x:
                high = mid
            else:
                low = mid + 1
        
        left = low - 1
        right = low
        
        while right - left - 1 < k:
            if left == -1:
                right += 1
                continue
            
            if right == len(arr) or abs(arr[left] - x) <= abs(arr[right] - x):
                left -= 1
            else:
                right += 1
            
        return arr[left+1:right]
