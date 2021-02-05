class Solution:
    #Solution 1
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #Approach: Binary Search and Two Pointers
        #Time Complexity: O(log n + k)
        #Space Complexity: O(1)
        
        closest = self.binarySearch(arr, x)
        low = closest
        high = closest
        
        while high - low < k - 1:
            if low == 0:
                high += 1
            elif high == len(arr) - 1:
                low -= 1
            elif x - arr[low - 1] <= arr[high + 1] - x:
                low -= 1
            else:
                high += 1
        
        return arr[low : high + 1]
    
    def binarySearch(self, arr, x):
        low = 0
        high = len(arr) - 1
        
        while high - low > 1:   #want to keep numbers just lower and higher
            mid = low + (high - low) // 2
            if arr[mid] == x:
                return mid
            elif arr[mid] > x:
                high = mid
            else:
                low = mid
        
        return low if x - arr[low] <= arr[high] - x else high
    
    #Solution 2
    """
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #Approach: Two Pointers
        #Time Complexity: O(n - k)
        #Space Complexity: O(1)
        
        low = 0
        high = len(arr) - 1
        
        while high - low >= k:
            if x - arr[low] <= arr[high] - x:
                high -= 1
            else:
                low += 1
        
        return arr[low : high + 1]
    """