# https://leetcode.com/problems/find-k-closest-elements/

# Time Complexity- O(log (n-k)) Space Complexity- O(1)

class Solution:
    def findClosestElements(self, arr, k, x):
        n = len(arr)
        # find the low and high pointer
        low, high = 0, n - k
        # iterate till the low is less than high
        while low < high:
            # find the mid point
            mid = low + (high - low) // 2
            # find the starting distance
            distS = x - arr[mid]
            # find the ending distance
            distE = arr[mid + k] - x
            # move the low pointer
            if distS > distE:
                low = mid + 1
            # move the hight pointer
            else:
                high = mid
        # define the result set
        result = []
        # iterate to get the range
        for i in range(low, low + k):
            result.append(arr[i])

        return result
