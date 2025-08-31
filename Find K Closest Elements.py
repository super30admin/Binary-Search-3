# Time Complexity : O(logn) + O(k)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach: This code finds the k closest elements to x in a sorted array. It first uses binary search to locate the position closest to x, then expands outwards using two pointers (left and right) to choose elements closer to x until k elements are picked. Finally, it collects the chosen elements from the range (left+1 … right-1) and returns them as the result.


class Solution:
    
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # TC: O(logn) + O(k)   SC: O(k)
        result = []

        left, right = 0, len(arr) - 1

        while left < right:
            mid = left + (right - left) // 2
            if arr[mid] < x:
                left = mid + 1
            else:
                right = mid
        
        left = right - 1

        while k > 0:
            if left < 0:
                right += 1
            elif right >= len(arr) or abs(arr[left] - x) <= abs(arr[right] - x):
                left -= 1
            else:
                right += 1
            k -= 1
            
        for i in range(left + 1, right):
            result.append(arr[i])
        
        return result