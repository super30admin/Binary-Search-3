## Problem2 
# Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)


# Method-1: Using brute force of getting all (distance, index) pairs and then sorting them
# N - Length of the array
# K - Number of closest elements to find
# Time Complexity : O(N * LogN) + O(K * LogK)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we first create an array of pairs containing (distance from x, index) for each element in the array.
# Then we sort this array based on distance and then index to get the k closest elements. Finally we sort the result array
# before returning it.

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # brute force
        # get all element distances from x and then sort the indices
        distArr = []
        for i in range(len(arr)):# O(N)
            distArr.append((abs(x - arr[i]), i))# pair of distance and index

        distArr.sort(key=lambda x:(x[0], x[1]))# O(N * LogN)
        res = []
        for i in range(k):# O(K)
            res.append(arr[distArr[i][1]])

        res.sort()# O(K * LogK)
        return res


sol = Solution()
print("Method-1: Using brute force of getting all (distance, index) pairs and then sorting them")
print(sol.findClosestElements([1,2,3,4,5], 4, 3))
print(sol.findClosestElements([1,1,2,3,4,5], 4, -1))


# Method-2: Using brute force of getting all values and sorting them based on distance from X and then value
# N - Length of the array
# K - Number of closest elements to find
# Time Complexity : O(N * LogN) + O(K * LogK)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The logic is same as above. Here we are storing just the values in the distance array instead of (distance, index) pairs.
# Just we are sorting based on distance from x and then value itself to get the k closest elements. Finally we sort the result array
# before returning it.

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # brute force
        # get all element distances from x and then sort the indices
        distArr = []
        for i in range(len(arr)):# O(N)
            distArr.append(arr[i])# distances

        distArr.sort(key=lambda a:(abs(a - x), a))# O(N * LogN) sort based on distance and then value
        res = []
        for i in range(k):# O(K)
            res.append(distArr[i])

        res.sort()# O(K * LogK)
        return res


sol = Solution()
print("Method-2: Using brute force of getting all values and sorting them based on distance from X and then value")
print(sol.findClosestElements([1,2,3,4,5], 4, 3))
print(sol.findClosestElements([1,1,2,3,4,5], 4, -1))


# Method-3: Using max heap with (distance, value) pairs
# N - Length of the array
# K - Number of closest elements to find
# Time Complexity : O(N * LogK) + O(K * LogK)
# Space Complexity : O(K)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we maintain a max heap of size k. Whenever size exceeds k, we pop the element from the heap with the largest distance from x.
# If distance is same, we pop the element with larger value. So after processing all the elements, we would have the 
# k closest elements in the heap. We then extract them and sort before returning.

import heapq
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # maxheap
        heap = []
        for i in range(len(arr)):# O(N * LogK)
            # adding the difference in the heap with negative sign to maintain it as 
            # max heap
            heapq.heappush(heap, (-(abs(arr[i] - x)), -arr[i]))
            # when difference is same,
            if(len(heap) > k):
                heapq.heappop(heap)

        # now we would have the top k elements with min distance from x in the heap
        res = []
        while(heap):
            _, ele = heapq.heappop(heap)
            res.append(-ele)

        res.sort()# O(K * LogK)
        return res
    
sol = Solution()
print("Method-3: Using max heap with (distance, value) pairs")
print(sol.findClosestElements([1,2,3,4,5], 4, 3))
print(sol.findClosestElements([1,1,2,3,4,5], 4, -1))


# Method-4: Finding the closest element using linear scan and then expanding outwards using two pointers and sorting
# N - Length of the array
# K - Number of closest elements to find
# Time Complexity : O(N) + O(K * LogK)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we first find the index of the closest element to x. Then we use two pointers, left and right to expand outwards from this
# index to note the closest k elements. At last we sort the result array before returning it. The beauty of this approach is that
# we do not need any extra space other than the result array.

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        closestInd = 0
        minDist = abs(arr[0] - x)
        for i in range(1, len(arr)):# O(N)
            if(abs(arr[i] - x) < minDist):
                # we found a closer element
                closestInd = i
                minDist = abs(arr[i] - x)

        res = []
        left = closestInd
        right = closestInd + 1
        while(len(res) < k):# O(K)
            if(left >= 0 and right < len(arr)):
                # both left and right exists
                # we need to check which is closer
                if(abs(arr[left] - x) <= abs(arr[right] - x)):
                    # left is closer
                    res.append(arr[left])
                    left -= 1
                else:
                    # right is closer
                    res.append(arr[right])
                    right += 1

            elif(left >= 0):
                # only left exists
                res.append(arr[left])
                left -= 1
            else:
                # only right exists
                res.append(arr[right])
                right += 1

        res.sort()# O(K * LogK)
        return res
    
sol = Solution()
print("Method-4: Finding the closest element using linear scan and then expanding outwards using two pointers and sorting")
print(sol.findClosestElements([1,2,3,4,5], 4, 3))
print(sol.findClosestElements([1,1,2,3,4,5], 4, -1))

# Method-5: Finding the closest element using linear scan and then expanding outwards using two pointers, without sorting
# N - Length of the array
# K - Number of closest elements to find
# Time Complexity : O(N) -- finding the closest element + O(K) -- expanding outwards using two pointers
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The approach is same as above. Just we maintain the left and right pointers in a way that we get the range of k closest elements
# directly without needing to sort the elements again. We find the first index that is closest to x. We mark this as the left pointer
# and the immediate next as the right pointer. Then we expand this window outwards from left and right to include k closest elements
# between them. If the left pointer reaches -1, we only include elements in the window from the right side. If the right pointer
# reaches the end then we only include elements in the window from the left side. If both the pointers are within the indices, then
# we bring the element into the window or expand towards that side where the element is closer.

# Using two pointers
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        closest = 0
        for i in range(1, len(arr)):
            if(abs(arr[i] - x) < abs(arr[closest] - x)):
                # current ele is the closest
                # update the closest
                closest = i

        # now expand from the closest outwards
        count = 0
        left = closest
        right = closest + 1
        while(count < k):
            if(left < 0):
                # move the right window
                right += 1
            elif(right >= len(arr)):
                # move the left window
                left -= 1
            else:
                # left >= 0
                # right < len(arr)
                # compare and check which one to include in the window
                if(abs(arr[right] - x) < abs(arr[left] - x)):
                    # right ele is closer
                    # include the right ele in the window
                    right += 1
                else:
                    # left ele is closer
                    # include the left ele in the window
                    left -= 1
            count += 1

        res = []
        for i in range(left + 1, right):
            res.append(arr[i])

        return res
    
sol = Solution()
print("Method-5: Finding the closest element using linear scan and then expanding outwards using two pointers, without sorting")
print(sol.findClosestElements([1,2,3,4,5], 4, 3))
print(sol.findClosestElements([1,1,2,3,4,5], 4, -1))

# Method-6: Using two pointers to eliminate larger distance elements until k elements remain
# N - Length of the array
# K - Number of closest elements to find
# Time Complexity : O(N - K) + O(K) = O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# This is a beautiful two pointer approach where we maintain one pointer at start and one at end of the array. 
# We keep removing the element which is farther from x until only k elements remain. The remaining elements are the closest ones.
# Also they would automatically be in sorted order as we are not changing their relative positions.

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # using two pointers
        # one at start and one at end
        # we keep removing the larger elements(wrt dist from x) till k remain
        left = 0
        right = len(arr) - 1
        while((right - left + 1) > k):
            if(abs(arr[left] - x) > abs(arr[right] - x)):
                # right element is closer so left element should be skipped
                left += 1
            else:
                # left element is closer so right element should be skipped
                # when both at same distance than also right should be skipped
                right -= 1

        res = []
        # elements would automatically come in sorted order
        for i in range(left, right + 1):
            res.append(arr[i])

        return res

sol = Solution()
print("Method-5: Using two pointers to eliminate larger distance elements until k elements remain")
print(sol.findClosestElements([1,2,3,4,5], 4, 3))
print(sol.findClosestElements([1,1,2,3,4,5], 4, -1))


# Method-7: Finding the closest element using binary search and then expanding outwards using two pointers
# N - Length of the array
# K - Number of closest elements to find
# Time Complexity : O(LogN) -- finding the closest element + O(K) -- expanding outwards using two pointers
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# This approach is similar to the linear scan + two pointer approach. The only difference is that here we use binary search
# to find the index of the closest element to x. We basically find the position where x would fit into the sorted array, that is the 
# inflection point. We do our binary search such that when the middle element is < x, we reduce our window from the left, making
# low = mid + 1. If the middle element >= x, we reduce our window from the right, making high = mid. It means this could potentially
# be our closest index. At the end, high would give us the right of the inflection point. So, our left would be high - 1
# Then we expand our window outwards to include the k closest elements in the range of [left + 1, right - 1]


class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        def binarySearch(arr, target):
            low = 0
            high = len(arr) - 1
            while(low < high):
                mid = low + ((high - low) // 2)
                if(target > arr[mid]):
                    low = mid + 1
                else:
                    high = mid           
            
            return high

        closest = binarySearch(arr, x)
        # print(closest)
        left = closest - 1
        right = closest

        count = 0
        while(count < k):
            if(left < 0):
                right += 1
            elif(right >= len(arr)):
                left -= 1
            else:
                # both left and right exists
                if(abs(arr[right] - x) < abs(arr[left] - x)):
                    # right ele is closer, include the right ele in the window
                    right += 1
                else:
                    # left ele is closer or equal, include the left ele in the window
                    left -= 1
            count += 1

        res = []
        for i in range(left + 1, right):
            res.append(arr[i])

        return res
    
sol = Solution()
print("Method-7: Finding the closest element using binary search and then expanding outwards using two pointers")
print(sol.findClosestElements([1,2,3,4,5], 4, 3))
print(sol.findClosestElements([1,1,2,3,4,5], 4, -1))


# Method-8: Using binary search to find the start of the range of k closest elements
# N - Length of the array
# K - Number of closest elements to find
# Time Complexity : O(LogN) -- finding the start of the range + O(K) -- to get and store the k closest elements
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we do the binary search to find the start of the range of k closest elements. Our low = 0 and high = len(arr) - k. This is the
# max possible range where our start could be. Our start of the range cannot be > (len(arr) - k) as beyond this point the number of 
# elements would be less than k. We find the mid and we check if this mid element could be our start. For that we get distStart 
# which is distance of mid(potential start of range) from x (x - arr[mid]). We also get the distEnd which is distance of 
# element that is k indices from mid(potential end of range) from x (arr[mid + k] - x). So x should somewhat in the middle of this
# potential start and potential end of the range. The distances should be somewhat same as x should behave as a balancing factor. 
# If (distStart <= distEnd), it means we have to move our high = mid that is reduce our right window. If (distStart > distEnd), 
# it means we have to move our low = mid + 1 that is reduce our left window. There are two important things to understand here.
# We are not taking the absolute distances here, because there can be duplicates or case when distances are same but of opposite sign
# and then distStart and distEnd distances would become same and we would select the wrong window. Also, we take mid + k elements 
# and not mid + k - 1 that is one element extra towards the end. This is because if we take distEnd from mid + k - 1 element and make
# decision based on that, we would be selecting the wrong window.



class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # we do binary search to find the start of the range of k closest elements
        low = 0
        high = len(arr) - k

        while(low < high):
            # low would never be equal to high
            mid = low + ((high - low) // 2)
            # now we check if this mid element could be the start of the range
            # we take distance of this start ele from x
            distStart = x - arr[mid]
            # our end index ideally would be mid + k - 1
            # but we take one extra element towards the end to handle duplicates
            # mid + k would never be out of bounds
            # only point where it could have been out of bounds is low = high, but that
            # case would never come
            distEnd = arr[mid + k] - x
            if(distStart <= distEnd):
                high = mid
            else:
                low = mid + 1

        res = []
        for i in range(low, low + k):
            res.append(arr[i])

        return res


sol = Solution()
print("Method-8: Using binary search to find the start of the range of k closest elements")
print(sol.findClosestElements([1,2,3,4,5], 4, 3))
print(sol.findClosestElements([1,1,2,3,4,5], 4, -1))