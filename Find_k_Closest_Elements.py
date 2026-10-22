# Time Complexity : O(log(n − k + 1) + k)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# First Approach using maxheap. Insert the elements into the heap by multiplying it with -1 since python doesnt support max heap default is min heap
# While innserting check if the length of heap > k if it is then pop the elements to maintain the length
# After inserting all elements and popping above k elements the heap size is of k elements
# Then we will go over the length of heap and pop elements in result array multiply by -1 and sort the result array
# Second Approach is two pointers where we have left and right pointer at 0 and len(arr)-1
# If the dist of left > dist of right we move the left by 1 else deacrese right by 1
# Then return left:left+k
# Third Approach Binary Search. Here we find the starting index of range. So we calculate the mid by having left at 0 and right at len(arr)-k
# Then check if arr[mid]-x > dist of arr[mid+k] - x then we move left to mid + 1 else right to mid
# Return left:left+k

import heapq
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) <= k:
            return arr
        maxheap = []
        result = []
        for num in arr:
            dist = abs(num - x)
            heapq.heappush(maxheap, (-dist, -num))
            if len(maxheap) > k:
                heapq.heappop(maxheap)
        for i in range(k):
            dist, val = heapq.heappop(maxheap)
            result.append(-val)
        return sorted(result)
#Time - O(n log k) where k log n is for popping elements from heap
#Space - O(k)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) <= k:
            return arr
        left = 0
        right = len(arr)-1
        while (right-left) >= k:
            distl = abs(arr[left]-x)
            distr = abs(arr[right]-x)
            if distl <= distr:
                right -= 1
            else:
                left += 1
        return arr[left:left+k]
#Time - O(N)
#Space - O(1)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) <= k:
            return arr
        left = 0
        right = len(arr) - k
        while left < right:
            mid = left + (right-left) // 2
            distmid = x-arr[mid]
            if distmid > (arr[mid+k] - x):
                left = mid + 1
            else:
                right = mid
        return arr[left:left+k]
#Time - O(log(n − k + 1) + k)
#Space - O(k)


        