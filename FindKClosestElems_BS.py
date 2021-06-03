# TC: O(log(N - k)) where N is the size of the input array, since we are reducing the search space by half everytime, hence logarithm. 
# SC: O(1) since we are not using any extra space

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) == 0: 
            return
        
        self.final = []
        low = 0
        high = len(arr) - k
        
        while low < high: 
            mid = (high + low) // 2
            distL =  x - arr[mid]
            distR = arr[mid + k] - x            
            if distL > distR:
                low = mid + 1
            else:
                high = mid
        
        for i in range(low, low + k):
            self.final.append(arr[i])
        
        return self.final
