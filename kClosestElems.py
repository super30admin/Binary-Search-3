# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# This approach uses 2 pointers to create a window, the two pointers are
# then used to compare the difference with the values and x. The pointers
# are moved in order to minimise the distance for both the pointers.
class Solution(object):
    def findClosestElementsTwoPointers(self, arr, k, x):
        low, high = 0, len(arr) - 1

        while high - low > k - 1:
            distL = abs(arr[low] - x)
            distH = abs(arr[high] - x)

            if distL > distH:
                low += 1
            else:
                high -= 1

        return arr[low:high + 1]

#------------------------------------------------------x---------------------------------------------------------------#

# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# This approach uses binary search to position the left pointer,
# The pointers are used to compare the position of the window created by mid & mid+k
# Duplicates are avoided by checking if the window has the same value throughout
# At the end low to low + k is the desired window to return
    def findClosestElementsBinarySearch(self, arr, k, x):
        low, high = 0, len(arr) - k

        while low < high:
            mid = low + (high - low) / 2
            distL = abs(x - arr[mid])
            distH = abs(x - arr[mid + k])

            if arr[mid] == arr[mid + k]:
                if x > arr[mid]:
                    low = mid + 1
                else:
                    high = mid
            else:
                if distL > distH:
                    low = mid + 1
                else:
                    high = mid

        return arr[low:low + k]
