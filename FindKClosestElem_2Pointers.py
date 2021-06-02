# TC: O(N) since we will be traversing all the elements using 2 pointers low and high. 
# SC: O(1) since we do not use any extra space.

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) == 0: 
            return
        
        self.final = []
        low = 0
        high = len(arr) - 1
        
        if high == low: 
            return [arr[low]]
        
        while high - low + 1 > k: 
            distL = abs(arr[low] - x)
            distR = abs(arr[high] - x)
            if distL > distR: 
                low += 1
            else:
                high -= 1
        
        for i in range(low, high + 1): 
            self.final.append(arr[i])
            
        return self.final
