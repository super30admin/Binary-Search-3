# Time Complexity : O(nlogn) for sorting, O(n) for finding the closest elements
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach 1: Sorting
# In this approach, we sort the array based on the absolute difference from x and then sort the first k elements to return the result.
class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        res = sorted(arr, key=lambda y: (abs(x-y), x))
        return sorted(res[:k])
    
# Time Complexity : O(logn + klogk) for sorting, O(n) for finding the closest element
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach 2: Two Pointers
# In this approach, we find the closest element to x and then use two pointers to find the k closest elements.
# We start from the closest element and expand outwards, comparing the distances of the left and right elements to x.
# We add the closer element to the result and move the pointer accordingly.
# Finally, we sort the result before returning it.
class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        # Initialize the index of the closest element
        curr_min = float("inf")
        # Iterate through the array and find the closest elemt to x
        for i in range(len(arr)):
            if abs(x - arr[i]) < curr_min:
                curr_min = abs(x - arr[i])
                idx = i

        # If the closest element is at the start or end of the array, return the first k or last k elements
        if idx == 0:
            return arr[:k]
        # If the closest element is at the end of the array, return the last k elements
        if idx == len(arr)-1:
            return arr[len(arr)-k:]
        
        # Initialize the left and right pointers
        l = idx
        # If the closest element is not at the start or end, we set the right pointer to the next element
        r = idx+1 if idx<len(arr)-1 else len(arr)-1
        # Initialize the result list
        res = []

        # Iterate until we have k elements in the result
        while len(res) < k:
            # Compare the distances of the left and right elements to x
            distL = abs(arr[l] - x) if l>=0 else float("inf")
            distR = abs(arr[r] - x) if r<len(arr) else float("inf")

            # If the left distance is less than or equal to the right distance, add the left element to the result
            # and move the left pointer to the left
            if distL <= distR:
                res.append(arr[l])
                l -= 1
            # If the right distance is less than the left distance, add the right element to the result
            # and move the right pointer to the right
            else:
                res.append(arr[r])
                r += 1

        # Sort the result before returning it
        return sorted(res)

# Time Complexity : O(nlog(n-k)) -> n for iterating through the array and adding elements to the heap, logk for heapify operation
# Space Complexity : O(n-k) for storing k elements in the heap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach 3: Min Heap
# In this approach, we use a min heap to keep track of the k closest elements to x.
# We iterate through the array and push the absolute difference, index, and element into the heap.
# If the size of the heap exceeds n-k, we pop the minimum element from the heap.
# The minimum element is the closest element to x.
# We repeat this process until we have k elements in the result.
# Finally, we sort the result before returning it.
import heapq  
class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        # Initialize the heap and result list
        heap = []
        res = []

        # Iterate through the array and push the absolute difference, index, and element into the heap
        for i in range(len(arr)):
            # Push the absolute difference, index, and element into the heap
            heapq.heappush(heap, (abs(x-arr[i]), i, arr[i]))
            # If the size of the heap exceeds n-k, pop the minimum element from the heap
            if len(heap) > len(arr)-k:
                ele = heapq.heappop(heap)
                # Add the minimum element to the result
                # The minimum element is the closest element to x
                res.append(ele[2])
        # Sort the result before returning it
        return sorted(res)
    
# Time Complexity : O(n)
# Space Complexity : O(1)

# Approach 4 : Two Pointers
# In this approach, we use two pointers to find the k closest elements to x.
# We start from the left and right pointers and compare the distances of the left and right elements to x.
# We keep moving away from the farthest element until we have k elements between the left and right pointers.
class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        # Initialize the left and right pointers
        l, r = 0, len(arr)-1

        # Iterate until we have k elements between the left and right pointers
        while r-l+1 != k:
            # Calculate the distances of the left and right elements to x
            distL = abs(x - arr[l])
            distR = abs(x - arr[r])

            # If the right distance is greater than the left distance, we want to move away from it, so move the right pointer
            if distL <= distR:
                r -= 1
            # Otherwise, we want to move away from the left element, so move the left pointer
            else:
                l += 1
        # Return the k closest elements between the left and right pointers
        return arr[l:r+1]

# Time Complexity : O(log(n-k))
# Space Complexity : O(1)

# Approach 5: Binary Search
# In this approach, we use binary search to find the k closest elements to x.
# Here, we're trying to find the leftmost index where the k closest elements start.
# We initialize the left and right pointers to 0 and len(arr)-k, respectively.
# We perform a binary search to find the index where the k closest elements start.
# We compare the absolute difference of the left and right elements to x.
# If the left element is closer to x, we move the right pointer to mid, since we don't know if the mid element is a part of the k closest elements.
# Otherwise, we move the left pointer to mid+1, since we can be sure that if the right element is giving a smaller distance, the mid element is not a part of the k closest elements.
# Finally, we return the k closest elements starting from the left pointer.
class Solution:
    def findClosestElements(self, arr, k: int, x: int):
        # Initialize the left and right pointers
        l, r = 0, len(arr)-k
        # Perform binary search to find the index where the k closest elements start
        while l < r:
            # Calculate the mid index
            mid = l + (r-l)//2
            # Compare the absolute difference of the left and right elements to x
            if arr[mid+k] - x < x - arr[mid]:
                # If the right element is closer to x, move the left pointer to mid+1
                l = mid+1
            # If the left element is closer to x, move the right pointer to mid
            else:
                r = mid
        # Return the k closest elements starting from the left pointer
        return arr[l:l+k]