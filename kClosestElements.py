"""
Approach --
Binary Search
1. Motive here is to find the beginning of the valid range of k elements.
2. Possible beginning can be from the index 0 to n-k. n-k as n-k+k will is the only last valid range available.
3. Perform the binary search from n = 0  to n-k range find the beginning of the valid range.
4. Find the mid then calculate the distErence of mid and mid+k elements from the x if distErence of mid is 
greater than correct start point is present on left, otherwise on right.
5. Once the correct start point is found, return low to low+k elements

TC : O(log(n-k) +k) ---> where n is the total number of elements in the array and
k is the kth number of elements that needs to be return. Binary search is perform on n-k elements.
SC : O(1)
"""
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k
        rtnData = []

        while low < high:
            mid = (low + high) // 2

            distS = x - arr[mid]
            distE = arr[mid+k] - x

            if distS > distE:
                low = mid + 1
            else:
                high = mid

        for i in range(low, low+k):
            rtnData.append(arr[i])

        return rtnData