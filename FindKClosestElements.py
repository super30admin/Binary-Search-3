"""
Approach: Two pointer

Here we are maintaining two pointers low and high, which will intially point to first and last element in the array respectively.

Our logic here we will keep moving the low and high pointer towards each other until the difference between them will be greater than k. Logic to move these pointers would be something like this.

If the difference between low and x is greater than difference between high and x, then we will move low by one point, because we will find less difference if the value of low if bigger. And if vice-versa is true then move high pointer by one.

Time complexity: O(n)
Space complexity: O(1)
"""

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if arr == None or len(arr) == 0:
            return result
        
        low = 0
        high = len(arr) - 1
        
        while high - low + 1 > k:
            diffL = abs(x - arr[low])
            diffR = abs(arr[high] - x)
            
            if diffL > diffR:
                low += 1
            else:
                high -= 1
                
        return arr[low: low+k]
            
        
"""
Approach: Two pointers + Binary Search

The original array has been sorted so we can take this advantage by the following steps.

If the target x is less or equal than the first element in the sorted array, the first k elements are the result.

Similarly, if the target x is more or equal than the last element in the sorted array, the last k elements are the result.

Otherwise, we can use binary search to find the index of the element, which is equal (when this list has x) or a little bit larger than x (when this list does not have it). Then set low to its left k-1 position, and high to the right k-1 position of this index as a start. The desired k numbers must in this rang [index-k-1, index+k-1]. So we can shrink this range to get the result using the following rules.

1)If low reaches the lowest index 0 or the low element is closer to x than the high element, decrease the high index.
2) If high reaches to the highest index arr.size()-1 or it is nearer to x than the low element, increase the low index.
3)The looping ends when there are exactly k elements in [low, high], the subList of which is the result. 

Time complexity: O(logn)
Space complexity: O(1)
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if arr == None or len(arr) == 0:
            return []
        
        low = self.binarySearch(arr, k, x, 0, len(arr) - k)
        return arr[low: low + k]
        
    def binarySearch(self,arr, k, x, low, high):
        while low <= high:
            first = low + (high-low) // 2
            last = first + k - 1
            if (first - 1 >= 0) and (x - arr[first - 1] <= arr[last] - x):
                high = first - 1
            elif (last + 1 < len(arr)) and (x - arr[first] > arr[last + 1] - x):
                low = first + 1
            else:
                return first
            
            
        return low
                
            
        
