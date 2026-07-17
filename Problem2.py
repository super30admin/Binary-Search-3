## Problem2 
# Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        """
        Solution 1: (Commented out)
        Time Complexity: O(N) 
        The two-pointer approach shrinks the window from size N to k, taking O(N - k) time. 
        Creating the final slice takes O(k) time. Overall time complexity is O(N).
        
        Space Complexity: O(1) auxiliary space
        We are only using a few pointers (l, r, a, b) which take constant extra space. 
        (Note: the returned slice takes O(k) space, which is typically excluded from auxiliary space analysis).
        """
        
        # Initialize two pointers at the beginning and end of the array
        # l, r = 0, len(arr) - 1
        
        # Keep shrinking the window until exactly k elements remain (r - l + 1 == k)
        # while (r - l + 1 > k):
            # Calculate the absolute difference from the target x for both ends
            # a = abs(arr[l] - x)
            # b = abs(arr[r] - x)
            
            # If the left element is closer to x, or equally close,
            # we keep the left element (as the problem favors smaller elements) 
            # and discard the right element by moving the right pointer inward.
            # if a <= b:
            #     r -= 1
            # If the right element is strictly closer to x, 
            # we discard the left element by moving the left pointer inward.
            # else:
            #     l += 1
                
        # Return the final window of k closest elements
        # return arr[l:r + 1]


        """
        Solution 2 (Binary Search):
        
        Time Complexity: O(log(N - k) + k)
        We binary search the starting index of the window which takes O(log(N - k)) time.
        Slicing the final array takes O(k) time.
        
        Space Complexity: O(1) auxiliary space
        We are only maintaining indices (l, r, m).
        """
        
        l, r = 0, len(arr) - k
        
        while l < r:
            m = l + (r - l) // 2
            
            # If the element at m + k is closer to x than the element at m,
            # or if they are equally close but m + k is closer in value to x 
            # (which happens when both are to the left of x), move right.
            if x - arr[m] > arr[m + k] - x:
                l = m + 1
            else:
                # Otherwise, the optimal window must start at m or to the left of m
                r = m
                
        return arr[r:r + k]