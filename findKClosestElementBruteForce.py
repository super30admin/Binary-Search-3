"""
Time Complexity : O(nlogn)+O(klogk) where n is the total number of elements in the array and 
                  k is the kth number of elements that needs to be return.
                  nlog(n) is the sorting complexity and then k iterations we need to do
Space Complexity : O(1) as no auxillary data structure is used

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Brute Force:
sort the array on the basis of actual difference of element and x
and then return the first k elements
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        """
        1.Actual Difference
        2.Heap
        3.Two pointers
        4.Binary search 
        5.Optimized Binary search (Find the starting point)
        """
        #Time Complexity: O(nlogn)+O(klogk)
        #Space Complexity: O(n)
        sortedArr = sorted(arr, key = lambda num: abs(x - num))
        
        result = []
        for i in range(k):
            result.append(sortedArr[i])
        
        return sorted(result)