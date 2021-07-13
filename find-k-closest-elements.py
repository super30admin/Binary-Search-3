# Approach 1 - Find the distance from x and sort them to get the nearest k is O(nlogn)
# Approach 2 - Closest Binary search with two pointers is O(logn) + O(k)
# Approach 3 - Max Heap is O(nlogk)
# Approach 4 - Two Pointer solution
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # To return the result 
        result = []
        # Null condition check
        if len(arr) == 0 or arr == None:
            return result
        
        low = 0
        high = len(arr) - 1
        # Check the condition that they must be k elements apart and since it is indices, add 1
        while (high - low + 1 > k):
            # Calculate the distance to x from both left and right sides
            # Move the pointer on the side where distance is greater
            distL = x - arr[low]
            distH = arr[high] - x
            if distL > distH:
                low = low + 1
            else:
                high = high - 1
        
        # At the end, low will have the starting element of k elements
        # Append them to result and return result
        for i in range(low, low + k):
            result.append(arr[i])
        return result
                




# Time complexity: O(log (n-k) + O(k))
# NOTE: To return the starting and ending index, find the left bound of range
# Binary search for left bound of Range
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # To return the result 
        result = []
        # Null condition check
        if len(arr) == 0 or arr == None:
            return result
        
        low = 0
        # Since they must be k elements apart 
        high = len(arr) - k
        
        while (low < high):
            mid = (high + low)//2
            distL = x - arr[mid]
            distH = arr[mid + k] - x
            if distL > distH:
                low = mid + 1
            else:
                high = mid
        
        # At the end, low will have the starting element of k elements
        # Append them to result and return result
        for i in range(low, low + k):
            result.append(arr[i])
        return result
                
            