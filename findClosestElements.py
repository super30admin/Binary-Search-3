


#Time complexity:O(log)n-k
#Space complexity:O(1)
#Ran successfully on Leetcode:Yes


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low=0
        high=len(arr)-k
        while low<high:
            mid=low+(high-low)//2
            # Here we check the mid and mid + k because our correct position for low pointer will be in between mid and min + k locations


            if abs(arr[mid]-x)>abs(arr[mid+k]-x):
                low=mid+1
            else:
                high=mid
        return arr[low:low+k]
                
