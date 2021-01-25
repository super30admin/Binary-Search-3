using two pointers:
# Runtime - O(n)
              # Memory - O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr:
            return []
        low=0
        high=len(arr)-1
        while(high-low+1)>k:
            diffL=abs(arr[low]-x)
            diffH=abs(arr[high]-x)
            if(diffL>diffH):
                low+=1
            else:
                high-=1
        return arr[low:high+1]

#brute force:
#  Runtime - nlogn
              # Memory - O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        return sorted(sorted(arr, key=lambda val: abs(val - x))[:k])
        