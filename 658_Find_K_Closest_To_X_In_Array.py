# Leetcode problem link : https://leetcode.com/problems/find-k-closest-elements/
# Time Complexity:    O(logn)
# Space Complexity:   O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    1. Keep high as length - k and move towards the starting point by using binary search
    2. To move, go towards high or low based on the distance of x from mid and mid+k elements.
    3. Once low and high cross, low will be pointing towards the starting point and we can return the next k elements from that point
'''
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if k > len(arr):
            return
        low = 0
        high = len(arr) - k
        
        while low < high:
            mid = low + (high - low)//2
            left_bound = abs(x - arr[mid])
            right_bound = abs(x - arr[mid+k])
            if left_bound > right_bound:
                low = mid + 1
            else:
                if arr[mid] == arr[mid+k]:
                    low = mid + 1
                else:
                    high = mid
            
        return arr[low:low+k]