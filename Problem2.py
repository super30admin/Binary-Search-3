'''
Time Complexity: O(log(n)) where n is length of arr
Space Complexity: O(1)
Run on Leetcode: YES
'''
class Solution:
    def findClosestElements(self, arr: list[int], k: int, x: int) -> list[int]:
        low = 0
        high = len(arr) - k
        while low < high:
            mid = low + (high - low)//2
            startdis = x - arr[mid]
            enddis = arr[mid + k] - x
            if startdis > enddis:
                low = mid + 1
            else:
                high = mid
        return arr[low:low + k]
    