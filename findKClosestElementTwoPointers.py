"""
Time Complexity : O(n) + O(k) where n is the number of elements in the array and 
                  k is the kth number of elements that needs to be return.
Space Complexity : O(1) as no auxillary data structure is use

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Place the low pointer at the beginning of the array and high pointer on the last element of the array.
2. Take the absolute difference between both high and low elements with the x and whichever is greater move that pointer.
3. Pointers will move till high - low == k
4. Once the third condition is reached, we will get the k closest elements.
5. Loop from low to high + 1 to get the required elements.
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) == 0:
            return []
        result = []
        low = 0
        high = len(arr) - 1
        
        while((high - low) + 1 != k):
            if abs(arr[low] - x) > abs(arr[high] - x):
                low = low+1
            else:
                high = high -1
                
        for i in range(low, high+1):
            result.append(arr[i])
        
        return result