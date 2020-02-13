import bisect
from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        """
            https://leetcode.com/problems/find-k-closest-elements/
            Time complexity - O(n)
            Space complexity - O(1)
            Three lines explanation -
                - Two pointers high and low
                - Move pointers till we don't find a window of size k
                - Move the pointer which is farther from x since we need the
                  closest elements from x.
        """
        # find 'K' closest elements from 'x'
        result = []
        if not arr:
            return result

        low = 0
        high = len(arr) - 1

        # till we don't have a window of size k
        while (high - low) + 1 > k:
            # how far is low pointer from x
            distL = abs(arr[low] - x)
            # how far is high pointer from x
            distR = abs(arr[high] - x)
            # we want the closest, so we move the one that is far
            if distL > distR:
                low += 1
            else:
                high -= 1

        return arr[low:low + k]

    def findClosestElements_BinarySearch(self, arr: List[int], k: int, x: int) -> List[int]:
        """
            https://leetcode.com/problems/find-k-closest-elements/
            Time complexity - O(logn)
            Space complexity - O(1)
            Three lines explanation -
                - Using bisect_left find the idx(or provided idx) in the arr
                - the candidates for closes k would only be in left k and right k elements of this idx.
                - then just simple do a two pointer to find right index range.
        """
        # find 'K' closest elements from 'x'
        result = []
        if not arr:
            return result

        idx = bisect.bisect_left(arr, x)  # O(log(n))

        low, high = max(0, idx - k), min(idx + k, len(arr) - 1)

        while (high - low) + 1 > k:
            # how far is low pointer from x
            distL = abs(arr[low] - x)
            # how far is high pointer from x
            distR = abs(arr[high] - x)
            # we want the closest, so we move the one that is far
            if distL > distR:
                low += 1
            else:
                high -= 1
        return arr[low: high + 1]


if __name__ == '__main__':
    Solution().findClosestElements_BinarySearch([1, 2, 3, 4, 5], 4, 3)
    Solution().findClosestElements([1, 2, 3, 4, 5], 4, 3)
    print(Solution().findClosestElements_BinarySearch([2, 5, 9, 11, 14, 19, 21, 22, 27], 3, 15))
    print(Solution().findClosestElements([2, 5, 9, 11, 14, 19, 21, 22, 27], 3, 15))
