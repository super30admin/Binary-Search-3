#passed in leetcode
#time - O(max(logn, k))
# space - O(1)



class Solution:
    def findClosestElements(self, arr, k, x):

        res = []

        target = x

        low = 0 #starting point
        high = len(arr) - k - 1  # To get the k values in array-- avoid out of bound.

        while low <= high:

            mid = low + (high - low) // 2
            if abs(arr[mid] - target) > abs(arr[mid + k] - target): #condition to reinitiate the high and low values
                low = mid + 1
            else:
                high = mid - 1
        for i in range(k):
            res.append(arr[low + i])
        return res