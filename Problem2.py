class Solution:
    
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
    
        """
        Description: Find k elements closest to given integer x in an array
        
        Time Complexicity: O(log n + k)
        Space Complexicity: O(1)
        
        Approach:
        - Find closest element's index using binary search
        - start a queue to add elements to right or left depending on the difference from x
        """
        
        cls_idx = self.closest(arr, x)
        result = deque([arr[cls_idx]])
        left, right = cls_idx - 1, cls_idx + 1
        while k > 1:
            if left < 0:
                result.append(arr[right])
                right += 1
            elif right == len(arr): 
                result.appendleft(arr[left])
                left -= 1
            else:
                if abs(x - arr[left]) > abs(x - arr[right]):
                    result.append(arr[right])
                    right += 1
                else:
                    result.appendleft(arr[left])
                    left -= 1
            # reduce count after adding an element
            k -= 1
                    
        return result
        
    def closest(self, arr, x):
        
        low = 0; high = len(arr) - 1
        
        while low < high:
            mid = low + (high - low) // 2
            if arr[mid] == x:
                return mid
            elif arr[mid] < x:
                low = mid + 1
            else: 
                high = mid
                
        if low == 0: return low
        if abs(x - arr[low]) < abs(x - arr[low - 1]): return low
        return low - 1 # From class (not clear yet)
