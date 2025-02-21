"""

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1
Output: [1,1,2,3]


Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104


Time Complexity: O(log(n-k) + k) → O(log n) for binary search + O(k) for slicing the array.
Space Complexity: O(k) → Output list of k elements.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# used binary search to find the left boundary of the k closest elements. 
# By maintaining a search range from index 0 to len(arr) - k, we compare differences between x and the current window edges.
# narrow down the range until we find the starting index, then return k consecutive elements.


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        l, r = 0, len(arr) - k

        while l < r:
            m = (l + r) // 2

            if x - arr[m] > arr[m + k] - x:
                l = m + 1
            else:
                r = m

        return arr[l:l + k]


