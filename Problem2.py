# Problem2:Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)
# Time Complexity: O(log(n - k)) for the binary search, plus O(k) to collect the final result
# Space Complexity: O(1), we only use a few variables, no extra data structure that grows with input
# Approach:
# We binary search on the starting index of our window of k elements, instead of checking every possible window one by one
# At each guess, we compare the number at the start of the window to the number just outside the window on the right
# If the number outside the window is closer to x, sliding the window right is better, so we move our search range right
# If the number at the start of the window is closer, we keep the window where it is or move it left
# Once the search range shrinks to one spot, that spot is the best starting index for our window
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        
        # low and high represent the range of valid starting indices for a window of size k
        # the window cannot start after index n minus k, or it would run off the end of the array
        low, high = 0, n - k

        # keep narrowing the search range until only one possible starting index remains
        while low < high:
            # pick a candidate starting index right in the middle of the current search range
            mid = low + (high - low) // 2

            # distS is how far the first number of this candidate window is from x
            distS = x - arr[mid]

            # distE is how far the number just outside the window on the right side is from x
            # this is the new number we would gain if we slid the window one step to the right
            distE = arr[mid + k] - x

            # if the start of the window is farther from x than the number we would gain by sliding right
            # then sliding right makes the window better, so we move the search range right
            if distS > distE:
                low = mid + 1
            else:
                # otherwise the window should stay here or move left, so we pull high down to mid
                high = mid

        # low and high are now equal, this is the best starting index we found
        result = []
        for i in range(low, low + k):
            # collect k numbers starting from the best starting index
            result.append(arr[i])
        return result