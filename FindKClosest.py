'''
Solution:
1.  First, compute the range where x can be present in the given array using Binary Search in logN time.
    Range gives the before and after index where x falls and if x is present in the array => range is the index itself
    both lower and higher indices.
2.  Once we find the range, move k elements either left or right based on the distances from x and return the subarray
    from left to right indices.

Time Complexity: O(logN + k)    | Space Complexity: O(1)

--- Passed all testcases successfully on leetcode
'''


class FindKClosest:

    def __findRangeBS(self, arr: List[int], x: int) -> tuple:

        #   initialize low and high pointers

        lo = 0
        hi = len(arr) - 1

        #   iterate till low doesn't meet high
        while (lo + 1 < hi):

            mid = lo + int((hi - lo) / 2)   #   compute mid

            if (x == arr[mid]):             #   if x is present in the array, return the index as [low, high]
                return (mid, mid)

            elif (x < arr[mid]):            #   if x is less than mid elem, move high to mid
                hi = mid

            else:                           #   if x is greater, move low to mid
                lo = mid

        return (lo, hi)                     #   return the [low, high] as the final range when out of the loop

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        #   initializations
        cnt = 0; n = len(arr)
        left, right = self.__findRangeBS(arr, x)

        #   if x present in the array, move left and right by 1 and increment the count
        if (left == right):
            cnt += 1
            left -= 1
            right += 1

        #   move left and right pointers until count is k
        while (cnt < k):
            if (left >= 0 and right < n):               #   if left and right are in array bounds
                if (x - arr[left] <= arr[right] - x):   #   if left elem is closer to x compared to right elem
                    left -= 1
                else:                                   #   if right elem is closer to x compared to left elem
                    right += 1

            elif (left < 0):                            #   if left elem is out of bounds
                right += 1

            else:                                       #   if right elem is out of bounds
                left -= 1

            cnt += 1

        return arr[left + 1: right]                     #   return the appropriate range