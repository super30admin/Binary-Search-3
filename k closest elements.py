class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #         # Approach 1:  Two pointers soln O(log (n-k) + k) time and constant space
        low = 0
        high = len(arr)-k # Note that we have hight ant n-k
        while(low < high):
            mid = low + (high - low)//2
            distL = x - arr[mid]
            distR = arr[mid+k] - x
            if distL>distR:
                low = mid+1
            else:
                high = mid
        
        return arr[low:low+k]
        
        
            
#         # Approach 2:  Two pointers soln O(n-k) time and constant space
#         low = 0
#         high = len(arr)-1
#         while(high - low + 1>k):
#             distL = abs(arr[low]-x)
#             distR = abs(arr[high]-x)
#             if distL>distR:
#                 low += 1
#             else:
#                 high -= 1
        
#         result = []
#         for i in range(low,high+1):
#             result.append(arr[i])
        
#         return result