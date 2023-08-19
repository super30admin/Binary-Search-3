# Time Complexity: O(logn) 
# Space Complexity: O(k) number of elements in the output list
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]: 
        l =0
        r = len(arr)-k
        while l<r:
            m = (l+r)//2
            if x -arr[m] > arr[m+k]-x:
                l =m+1
            else:
                r =m
        return arr[l:l+k]

