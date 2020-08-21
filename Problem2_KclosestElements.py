#Problem 2:https://leetcode.com/problems/find-k-closest-elements/
#Test Cases passed on Leetcode 
#Binary Search Used
#Time Complexity-O(log(n-k))
#Space Complexity-O(k)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #Binary search approach used
        left = 0
        right = len(arr) - k
        
        while left < right:
            mid = left + (right - left)//2
            #Did not take absolute since there can be duplicates in the array
            if x - arr[mid] >arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left : left + k]