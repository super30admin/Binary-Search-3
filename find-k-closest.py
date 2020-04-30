"""
## Problem2
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)


Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104




"""

#O(n-k) or O(N)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) == 1:    # edge case
            return arr
        if len(arr) == 0:    # edge case
            return []
        l = 0        # low pointer
        output = []      # output list
        h = len(arr) - 1      # high pointer
        while h - l + 1 != k:           # we will run the loop until diff between h and l is k
            Ldistance = abs(x - arr[l])    # check difference between given element and the elements at low and hugh
            Rdistance = abs(x - arr[h])
            if Ldistance > Rdistance:    #move cursor to l to right side if Ldistance is greater than Rdistance
                l = l + 1
            else:
                h = h - 1

        # at end of above while loop we will get range of k elements starting from l till h

        while l <= h:        # add all elements between l and h to output
            output.append(arr[l])
            l = l + 1
        return output


#TIME - LOG(N)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        output = []
        # if len(arr)==1:
        #     return arr
        # if len(arr)==0:
        #     return []
        l = 0
        h = len(arr) - k
        while l < h:
            mid = l + (h - l) // 2
            Lbound = abs(x - arr[mid])
            Rbound = abs(x - arr[k + mid])

            if Lbound > Rbound:
                l = mid + 1
            else:
                h = mid

        for i in range(l, l + k):
            output.append(arr[i])
        return output




