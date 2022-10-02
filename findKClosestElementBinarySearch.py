"""
Time Complexity : O(log(n-k)) + k where n is the total number of elements in the array and 
                  k is the kth number of elements that needs to be return.
                  Binary search is perform on n-k elements.
Space Complexity : O(1) as no auxillary data structure is used

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Brute Force:
1. Motive here is to find the beginning of the valid range of k elements.
2. Possible begining can be from the index 0 to n-k. n-k as n-k+k will is the only last valid range available.
3. Perform the binary search from n = 0  to n-k range find the beginning of the valid range.
4. Find the mid then calculate the difference of mid and mid+k elements from the x if difference of mid is greater then correct start point is present on left, otherwise on right.
5. Once the correct start point is found, return low to low+k elements
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #Time Complexity: O(log(n-k)) + k
        #Space Complexity: O(1)
        low = 0
        high = len(arr) - k
        result = []
        
        while(low < high):
            mid = (low + high) // 2
            
            diffS = x - arr[mid]
            diffE = arr[mid+k] - x
            
            if diffS > diffE:
                low = mid + 1
            else:
                high = mid

        for i in range(low, low+k):
            result.append(arr[i])
        
        return result