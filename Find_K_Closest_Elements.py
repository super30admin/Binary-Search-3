from collections import deque

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        if not arr:
            return []
        
        result = deque()
        closest = self.binarysearch(arr,x)
        result.append(arr[closest])
        left = closest - 1 
        right = closest + 1
        
        while k > 1:
            if left<0:
                result.append(arr[right])
                right +=1
            elif right==len(arr):
                result.appendleft(arr[left])
                left -=1
            else:
                if x - arr[left] <= arr[right] - x:
                    result.appendleft(arr[left])
                    left -=1
                else:
                    result.append(arr[right])
                    right +=1
            k -=1       
                    
        return result
        
    def binarysearch(self,arr,x):
        
        low = 0
        high = len(arr)-1
        while low < high:
            mid = low + (high-low) // 2
            if arr[mid]==x:
                return mid
            elif arr[mid] < x:
                low = mid +1
            else:
                high = mid 
        #print(low,high,mid)
        if low == 0 :
            return low
        if abs(arr[low] - x) < abs(arr[low-1] - x):
            return low
        return low-1
