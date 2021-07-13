# Time Complexity: O(log(n-k))
# Space COmplexity: O(1)
class Solution:
    def findClosestElements(self, arr,k, x):
        #         defining 2 pointers
        low = 0

        high = len(arr) - k
        #         until low is less than high
        # we will calculate the mid and check the difference
        # between mid and mid+k with x and move low and high pointer accordingly
        while low < high:
            mid = (low + high) // 2

            if x - arr[mid] > arr[mid + k] - x:
                low = mid + 1
            else:
                high = mid
        #         return the list starting from low to low + k as it is sorted list
        return arr[low: low + k]
