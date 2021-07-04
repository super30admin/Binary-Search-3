"""
658. Find K Closest Elements

Time Complexity: O(log(N-k)) where n = number of elements in input array
Space Complexity : O(k) to create return result 
Successfully excecuted on leetcode

"""

class Closest:
    def findClosestElements(self, A, k, x):
        left, right = 0, len(A) - k
        while left < right:
            mid = (left + right) / 2
            if x - A[mid] > A[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return A[left:left + k]