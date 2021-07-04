# Time Complexity : O(n logn)
# Space Complexity : O(1) (Not using any extar space)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - If x is smaller than first element than return first k elements and if x is greater than last element return last k elements.
# - In all other cases, sort the array by every elements distance to x. Get the first k element from it.
# - Sort the result with k elements and return it.

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
#       If x is smaller than first element than return first k elements
        if x <= arr[0]:
            return arr[:k]
#       if x is greater than last element return last k elements
        elif x >= arr[-1]:
            return arr[-k:]
        else:
#           Sort the array by every elements distance to x.
            arr.sort(key = lambda element: abs(element - x))
#           Get first k elements that means k elements with shortest distance to x.
            arr = arr[:k]
#           Again sort the array because we want answer sorted.
            arr.sort()
            return arr
