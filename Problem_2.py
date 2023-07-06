"""
Problem : 2

Time Complexity : O(log(n))
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Using two pointers at the start and end of the input array, while maintaining the distance between them to be at maximum k
calculating the absolute distance between the given number and the numbers at respective pointer, and moving the pointer in the direction
which promises lower distances, at the end, the two pointers would have stopped at the substring which is useful for result,
then hovering over the substring using the pointers and appending numbers to the result and returning it in the end
"""


# Find K Closest Elements

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        l=0
        r=len(arr)-1
        while r-l+1>k:
            distL=abs(arr[l]-x)
            distR=abs(arr[r]-x)
            if distL>distR:
                l+=1
            else:
                r-=1
        result=[]
        for i in range(l,r+1):
            result.append(arr[i])
        return result

