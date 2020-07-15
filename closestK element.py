#Time Complexity : O(N) where N is number of elementa
#Sapce Complexity : O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr) -1
        result = []
    
        while(right - (left) +1> k):
            if abs(arr[left] - x ) > abs(arr[right] - x):
                left+=1
            else:
                right-=1
    
        return arr[left:right+1]
=============================================================================
#Condtions No dulicate
#Time Complexity : O(LogN) where N is number of element 
#Sapce Complexity : O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr) -k
    
        while(left < right):
            mid = left + (right -left)//2 
            if abs(x - arr[mid]) > abs(x - arr[mid+k]):
                left = mid+1
            else:
                right =mid
        return arr[left:left+k]