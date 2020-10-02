# Time Complexity -  O(nlogn)
# Space Complexity -  O(n)
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        newArray = []
        for i in range(len(arr)):
            diff = abs(x-arr[i])
            newArray.append((diff, arr[i]))
        
        newSorted = sorted(newArray, key= lambda x: x[0])
        
        result = []
        for i in range(k):
            result.append(newSorted[i][1])
        return sorted(result)
    # Time Complexity -  O(logn)
    # Space Complexity -  O(1)
    def findClosestElements2(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        if x <= arr[0]: return arr[:k]
        if x >= arr[-1]: return arr[-k:]
        low = 0
        high = len(arr) - k
        while low < high:
            mid = int(low + (high - low) / 2)
            l_distance = abs(x - arr[mid])
            r_distance = abs(x - arr[mid+k])
            if l_distance > r_distance:
                low = mid + 1
            else:
                high = mid
        return arr[low: low+k]