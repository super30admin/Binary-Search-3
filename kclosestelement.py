'''
Time Complexity O(log(n-k))
Space complexity O(k) (output array)
binary search 

'''

class Solution:
    def findClosestElements(self, nums: List[int], k: int, x: int) -> List[int]:
        n = len(nums)
        if n==0: return []
        if k == 0: return []
        if n==1 and k == 1: return nums
        
        low = 0
        high = n - k
        while low <= high:
            first = low + (high - low)//2
            last = first  + k - 1
            
            if first-1>=0  and (x - nums[first -1]) <= (nums[last] - x):
                high = first - 1
            elif last + 1 < n and (x - nums[first]) > (nums[last + 1] -x):
                low = first + 1
            else: 
                break
    
        return nums[first:last+1]
            
        
#         n = len(nums)
#         if n==0: return []
#         if k == 0: return []
#         if n == 1 and k == 1: return nums
#         left = 0
#         right = n-1
#         while left <= right:
#             mid = left + (right-left)//2
#             if nums[mid] == x:
#                 break
#             elif x >nums[mid]:
#                 left = mid + 1
#             else:
#                 right =  mid -1
                

#         i = mid
#         j = mid 
#         ans = []
#         while k>=0:
#             if j>=n or abs(nums[i] - x) <= abs(nums[j] - x):
#                 i -= 1
#                 k -= 1
#             else : #if  i<0 or abs(nums[j] - x) < abs(nums[i] - x):
#                 j += 1
#                 k -= 1
#         return nums[i+1:j]
