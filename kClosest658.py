# Approach 1 - Two pointer 
# TC - O(n -k)
# SC - Nothong stored
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr or len(arr) == 0:
            return []
        
        low = 0 
        high = len(arr) - 1
        
        while (high - low + 1> k):
            if (abs(x - arr[low]) > abs(x - arr[high])):
                low += 1
            else: # equal or otherwise
                high -= 1
        print(low, high)        
        return arr[low: high+1]

    
# Approach 1 - Binary search and two pointer 
# TC - O(log n + k -1) -> O (logn + k)
# SC - O(1) Nothong stored apart from temp variable 
class Solution:
    def binarySearch(self, arr: List[int], target: int) -> int:
        low = 0 
        high = len(arr) - 1
        
        while(low < high):
            mid = low + (high - low)//2
            if arr[mid] == target:
                return mid 
            elif (target > arr[mid]):
                low = mid + 1
                
            else:
                high = mid
            
        if low == 0:
            return 0
        if ( abs( target - arr[low] ) < abs( target - arr[low-1] ) ):
            return low
        
        else:
            return low - 1 

    
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr or len(arr) == 0:
            return []
        
        result = []
        closest = self.binarySearch(arr, x)

        print(closest)
        left = closest - 1
        right = closest + 1
        result.append(arr[closest])
        print(result)
        while(k > 1):
            if left < 0:
#                 
                result.append(arr[right])
                right += 1
        
            elif right == len(arr):
                temp = []
                temp.append(arr[left])
                left -= 1
                print(temp)
                temp.extend(result)
                result = temp
                #print(result)
            else:
                if x - arr[left] <= arr[right] - x:
                    
                    temp_list = []
                    temp_list.append(arr[left])
                    left -= 1
                    temp_list.extend(result)
                    result = temp_list
                    
                else:
                    
                    result.append(arr[right])
                    right += 1
            k -= 1
        return result
       
        
        