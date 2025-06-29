# // Time Complexity : O(logn)
# // Space Complexity : O(logn)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# We can do it in heap - have a distance matrix, and add to max heap of size k

# we can use a 2 pointer solution - starting from both ends, and keep increasing/decreasing L & R based on 
# which is futher from the answer
# l, h = 0, len(arr) - 1
# while h - l + 1 > k:
#     distL = abs(x-arr[l])
#     distH = abs(x-arr[h])
#     if distL > distH:
#         l += 1
#     else:
#         h -= 1
# return arr[l:h+1]

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # Binary search solution: key -> we want to find the starting index of the k-length window. 
        # we start with low at 0 & high at length - k. 
        # we then continue until low != high
        # we find the mid (this is the start of our window)
        # once we find it, we check the start of the window & the end of the window (mid + k)
        # which ever is smaller, we go in that direction
        # return [mid, mid + k -1] 
        l, h = 0, len(arr) - k
        while l < h:
            mid = (l+h)//2
            if x - arr[mid] > arr[mid + k] - x:
                l = mid + 1
            else: 
                h = mid 
        return arr[l:l+k]

