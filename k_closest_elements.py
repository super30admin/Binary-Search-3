# Time Complexity: O(log n + k)
# Space Complexity: O(k)
from collections import deque
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = deque()
        if(arr == None or len(arr) == 0):
            return result
        
        def binarysearch(arr, x):
            low = 0 
            high = len(arr) -1
            
            while(low < high):
                mid = low + (high - low) // 2
                if(arr[mid] == x): return mid
                elif(arr[mid] < x):
                    low = mid + 1
                else:
                    high = mid
            if(low == 0): return low
            if(abs(arr[low] - x) < abs(arr[low-1] - x)):
                return low
            else:
                return low-1
                
                
        closest = binarysearch(arr, x)
        #print(closest)
        result.append(arr[closest])
        #print(result)
        r = closest + 1
        l = closest - 1
        while(len(result) < k): #change this
            if(l < 0):
                result.append(arr[r])
                r += 1
            elif(r == len(arr)):
                result.appendleft(arr[l])
                l -= 1
            else:
                if(x - arr[l] > arr[r] - x):
                    result.append(arr[r])
                    r += 1
                else:
                    result.appendleft(arr[l])
                    l -= 1
            #k -= 1
        return result