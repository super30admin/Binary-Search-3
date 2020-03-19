'''
Time Complexity: O(log(n-k)+k) approx O(n)
Space Complexity: O(k)
Did this code successfully run on Leetcode : Yes
Explanation: Use binary search to find the element x and choose the bounds where the closest elements are,
after finding x use the bounds to populate the array for k
'''


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []

        if arr == None or len(arr) == 0:
            return []

        low = 0
        high = len(arr) - k

        while low < high:
            mid = int(low + (high - low) / 2)
            # distance of mid > distance of mid+k
            # ie |x - arr[mid]| , |arr[mid+k] - x|
            if abs(x - arr[mid]) > abs(arr[mid + k] - x):
                low = mid + 1
            else:
                high = mid

        for i in range(0, k):
            result.append(arr[low + i])

        return result