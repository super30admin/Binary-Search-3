"""
https://leetcode.com/problems/find-k-closest-elements/
:return

"""

import heapq


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        ###two pointer solution(O(n)) time
        # low=0
        # high=len(arr)-1
        # result=[]
        # while high-low+1>k:
        #     if abs(arr[low]-x)>abs(arr[high]-x):
        #         ##low bara hai
        #         low+=1
        #     else:
        #         high-=1
        # for i in range(low,high+1):
        #     result.append(arr[i])
        # return result

        ###o log n +k below
        ###base case
        ###arr=10 to 8 pe nahin ho sakta 7 pe ho sakta hai rightmost index

        """
        Given
N
N as the length of arr,

Time complexity:

O(log(N−k)+k).

Although finding the bounds only takes

O(log(N−k)) time from the binary search, it still costs us

O(k) to build the final output.

Both the Java and Python implementations require

O(k) time to build the result.
Space complexity:
O(1).

Again, we use a constant amount of space for our pointers, and space used for the output does not count towards the space complexity.
        """
        left = 0
        right = len(arr) - k
        while left < right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left + k]




