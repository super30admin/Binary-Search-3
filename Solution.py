'''
// Time Complexity :
# Problem 1 - O(n!) where n is each row of the matrix
# Problem 2 - O(n - k) k is the no. of elements (2 Pointers)
            - O(log N + k) log N - Binary search and k is no. of elements (Binary Search)
// Space Complexity :
# Problem 1 - O(n*n) as all elements are appended in a list array and an extra parse on the board
# Problem 2 - O(n) worst case if k is equal to length of array - O(1) amortized
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.

// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1 - Pow(x,n)
# Check if n is negative and x is '0' we return infinite else change x to 1/x and reverse sign of n
# Check edge cases where n is '0' we return 1 and if n is '1' we return the value x
# Recursively call the function to operate on half of the power n/2 and use the result to multiply with 
# itself in case of even power to return result else if the power is odd we multiply it by x.

class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n < 0:
            if (x == 0):
                return float('inf')
            x = 1 / x
            n = -1 * n  
        
        if n == 0: return 1
        if n == 1: return x

        re = self.myPow(x, int(n / 2))
        if n%2 == 0:
            return re*re
        else:
            return re*re*x
        
## Problem 2 - K closest elements
# 2 Pointers
# Take left pointer as '0' and right pointer as length of array.
# Iterate until the difference of low and high is more than or equal to k elements that we need to 
# return.
# Get the difference between left most element and x along with the right most element and x.
# If the distance of left element is greater than right element then we increment left pointer else 
# decrement the right pointer
# Return the result list with elements between the left and right pointer.

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        n = len(arr)
        left = 0
        right = n-1
        while right-left >= k:
            distL = abs(arr[left] - x)
            distR = abs(arr[right] - x)
            if distL > distR:
                left += 1
            else:
                right -= 1
        result = []
        for i in range(left, right+1):
            result.append(arr[i])
        return result

# Binary Search
# Initialize the low with '0' and high as length of array - k elements
# Binary search - Find the mid element taking the average of low and high
# Calculate the start distance as x minus the mid element and end distance as mid + k element minus x
# If start distance is greater than the end distance we move the low to mid + 1 element else move high
# to mid element and perform the Binary search again until the low and high cross eachother.
# Return the result array with elements between low and low + k.
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        n = len(arr)
        low = 0
        high = n - k
        while low < high:
            mid = low + (high - low) / 2
            distS = x - arr[mid]
            distE = arr[mid + k] - x
            if distS > distE:
                low = mid + 1
            else:
                high = mid
        result = []
        for i in range(low, low + k):
            result.append(arr[i])
        return result