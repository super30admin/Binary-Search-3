"""
Apply binary search to find left boundary of a size-k window
Compare elements at both ends to find the closest window
Return arr[left:left+k]
"""
"""
Time Complexity: O(log(n - k)) - Binary search over window start ; O(k) - to collect the result
Space Complexity: O(1) extra
"""


class kClosestElements:
    def findClosestElements(self, arr, k, x):
        left = 0
        right = len(arr) - k

        while left < right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid
        return arr[left:left + k]


obj = kClosestElements()
print(obj.findClosestElements([1,2,3,4,5], 4, 3))
print(obj.findClosestElements([1,2,3,4,5], 4, -1))
