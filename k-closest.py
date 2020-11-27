# Time Complexity: O(logN + K) We need O(logN) for Binary Search and O(K)for finding the ‘K’ closest numbers using the two pointers.
# Space Complexity: O(1)
# Approach: Find the index of x using binary search. if it's not in the array, find it's left insertion index.
# Initialize two pointers and search for K elements on either side of the index by minimizithe difference.

import bisect


class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # Find the index of number
        index = bisect.bisect_left(arr, x) - 1
        nums = arr
        left, right = index, index+1
        res = collections.deque()
        count = 0
        while left >= 0 and right < len(nums) and count < k:
            leftdiff = abs(x - nums[left])
            rightdiff = abs(x - nums[right])
            if leftdiff <= rightdiff:
                res.appendleft(nums[left])
                left -= 1
                count += 1
            else:
                res.append(nums[right])
                right += 1
                count += 1
        while left >= 0 and count < k:
            res.appendleft(nums[left])
            left -= 1
            count += 1

        while right < len(nums) and count < k:
            res.append(nums[right])
            right += 1
            count += 1

        return res
