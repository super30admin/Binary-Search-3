#approach, here we will find the starting index of the required array by comparing the start and end indices using binary search
#Time: O(log(n-k)) + O(k)
#space: O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        low=0
        high= len(arr)-k
        while low < high:
            mid= low + int((high-low)/2)
            start_d= x- arr[mid]
            end_d= arr[mid+k] - x

            if start_d > end_d:
                low= mid+1
            else:
                high=mid

        return arr[low:low+k]
