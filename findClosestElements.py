class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        low = 0
        high = len(arr)-k
        while low<high:
            start = (low+high)//2
            end = start + k
            if (x-arr[start]) <= (arr[end]-x):
                high = start
            else:
                low = start+1
        return arr[low: low+k]
            
    Time: O(log(n))
    Space : O(1)
      
