class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left=0
        right=len(arr)-1
        
        while right-left+1>k:
            if abs(arr[right]-x)>abs(arr[left]-x):
                right-=1
            elif abs(arr[right]-x)<abs(arr[left]-x):
                left+=1
            else:
                right-=1
                
        return arr[left:right+1]