# Brute Force Approach - Since the numbers are sorted, we can sort the abs differences between the numbers and target number and return the k closest numbers as the result
# Time - O( N log N)
# Space - O(1)

# Optimized solution1 - Use a heap to store the k closest numbers
# Time - O(N log K) where k is the size of the heap
# Space - O(K)

# Optimized solution 2 - Use 2 pointers since the numbers are sorted
# Always maintain a range k to perform the 2 pointer search and check the abs differences between target and low, high pointer values

# Time - O(N -K) ~= O(N)
# Space - O(1) no space used

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        result = []
        
        if not arr or len(arr) == 0:
            return result
        
        low = 0
        high = len(arr) - 1
        
        while (high - low) >= k:
            
            if abs(x - arr[low]) >  abs(arr[high] - x):
                low += 1
                
            else:
                high -= 1
                
        # low to high indices contains the k closest elements so to include the end index, go up till high + 1    
        for val in range(low, high+1):
            result.append(arr[val])
            
        return result


# Optimized solution 3: Binary search + 2 pointers
# Time - O(log N + k) where log N is for finding closest and k for returning k elements in the result
# Space - O(N)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        result = []
        if arr is None or len(arr) == 0:
            return result
        
         
        closest = self.binary(arr, 0, len(arr)-k, k, x)
        n = closest + k
        while closest < n:
            result.append(arr[closest])
            closest += 1
        return result    
    
    def binary(self, arr, low, high, k, x):
        
        while low <= high:
            
            midd = low + (high-low) // 2
            last = midd + k -1
             
            # boundary checks
            if midd - 1 >= 0 and x-arr[midd-1] <= arr[last] - x:
                high = midd - 1
             
            elif last + 1 < len(arr) and x - arr[midd] > arr[last + 1] - x:
                low = midd + 1
            
            else:
                return midd

