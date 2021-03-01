# // Time Complexity : O(logn) for binary || O(n-k) for two pointer
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# 1. BINARY SOLn
# We run binary search to find the first index of the resultant array
# with high at n-k
# We find fisrt and last pointer where first pointer is mid and last is mid+k-1
# we check the boundaries of both these pointers and move low and high accordingly

# 2. Window
# keeping two pointers at ends we move them towards mid
# When we find the distance between them is k we return

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if arr == None or len(arr) ==0: return []
        low = 0
        high = len(arr)-k
        f = self.binarySearch(low, high, arr,k,x)
        return arr[f:f+k]
    
    def binarySearch(self,low, high, arr,k,x):
        while low<=high:
            first = (low + high)//2
            last = first + k - 1
            if first> 0 and (x - arr[first - 1] <= arr[last] - x):
                high = first - 1
            elif last<len(arr)-1 and (x - arr[first] > arr[last + 1]-x):
                low = first + 1
            else:
                return first
        return low
        
        
#         low = 0
#         high = len(arr)-1
        
#         while high-low+1 > k:
               
#             if x-arr[low]>arr[high]-x:
#                 low+=1
#             else:
#                 high-=1
                
#         return arr[low:high+1]