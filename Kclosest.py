'''
time complexity:O(n)
space complexity: O(1)
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l = 0
        h = len(arr)-k
        
        while(l<h):
            mid = (l+h)//2
            distl = x - arr[mid]
            distr = arr[mid+k] - x
            if(distl>distr):
                l = mid+1
            else:
                h = mid
                
        return arr[l:l+k]