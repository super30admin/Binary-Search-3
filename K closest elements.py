#// Time Complexity : O(log n) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k

        while low < high:
            mid = low + (high - low) // 2
            distS = arr[mid] - x
            distE = arr[mid + k] - x
            if distS > distE:
                low = mid + 1
            else:
                high = mid
      
        
        return  arr[low:low + k]

# Approach:
# The problem can be solved using a modified binary search algorithm. The idea is to find the closest pair
# of elements to the target number x in the given array arr. We start by initializing two pointers,
# low and high, to the start and end - k of the array respectively. We then enter a while loop
# that continues until low is less than high. In each iteration, we calculate the middle index mid
# and calculate the distance between the middle element and the target number x. We also calculate the
# distance between the middle + kth element and the target number x. If the distance between the middle
# element and the target number x is greater than the distance between the middle + kth element and the
# target number x, we move the low pointer to mid + 1. Otherwise, we move the
# high pointer to mid.
        