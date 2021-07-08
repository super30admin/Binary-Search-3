'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 658. Find K Closest Elements


# https://leetcode.com/problems/find-k-closest-elements/

#-----------------
# Time Complexity: 
#-----------------
# O(Log(N-k) + k) - Where N is the length of input array

#------------------
# Space Complexity: 
#------------------
# O(1): Constant space

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        left = 0 
        right = len(arr) - k
        while left < right:
            mid = left + (right - left)//2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        
        return arr[left:left + k]
            