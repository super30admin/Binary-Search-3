# 658. Find K Closest Elements

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k
        while low<high:
            mid = low + (high-low)//2
            print("mid", mid)
            
            distS = x - arr[mid]
            disE = arr[mid+k] - x

            if distS <= disE:
                high = mid
            else:
                low = mid+1
        
        result = []
        for i in range(low, low + k):
            result.append(arr[i])

        return result

        
        
        

