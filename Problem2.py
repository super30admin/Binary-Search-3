#time Complexity : O(O(log(N−k)+k))
#Space Complexity: O(k)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        low = 0
        high = len(arr) - k
        
        while low < high:
            mid = (low + high)//2
            startdiff = x - arr[mid]
            enddiff = arr[mid+k] - x
            
            if startdiff > enddiff:
                low = mid + 1
            else:
                high = mid
        li = []     
        for i in range(low,low+k):
            li.append(arr[i])
            
        return li
                