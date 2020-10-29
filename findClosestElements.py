# Time complexity : O(logn+k). O(logn) is for the time of binary search, while O(k) is for shrinking the index range to k elements.

# Space complexity : O(k). It is to generate the required sublist.

class Solution(object):
    def findClosestElements(self, A, k, x):
        left = 0
        right = len(A) - k
        
        while left < right:
            mid = (left + right) / 2
            if x - A[mid] > A[mid + k] - x:
                left = mid + 1
            else:
                right = mid
                
        return A[left:left + k]