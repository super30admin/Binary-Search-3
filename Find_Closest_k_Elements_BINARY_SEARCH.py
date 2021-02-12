# Created by Aashish Adhikari at 6:50 PM 2/11/2021

'''
Time Complexity:
O( k + logn)

Space Complexity:
O(1)
'''


class Node:
    def __init__(self, data=None):
        self.val = data
        self.next = None

class Solution(object):


    # Modified binary search where we want to find the element just equal to or to the right of the target
    # We will not skip HIGH pointer while reducing the search space.
    # loop does not enter LOW == HIGH
    def binary_search(self, arr, target):
        low = 0
        high = len(arr)-1

        while low < high:

            mid = low +  ((high-low)/2)

            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid # not mid + 1

        # if the search space decreased such that low == 0
        if low == 0:
            return low

        if abs(arr[low] - target) < abs(arr[low-1]-target):
            return low

        return low-1





    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """

        closest = self.binary_search(arr,x)
        left = closest-1
        right = closest+1

        from collections import deque

        sol = deque()
        sol.append(arr[closest])

        while k > 1: # not k > 0 because the closest element already appended.

            if left < 0:
                sol.append(arr[right])
                right += 1
            elif right == len(arr):

                sol.appendleft(arr[left])
                left -= 1
            else:
                if x - arr[left] > arr[right] - x:
                    sol.append(arr[right])
                    right += 1
                else:
                    sol.appendleft(arr[left])
                    left -=1

            k -= 1

        return sol




