class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        
        low = 0 
        high = len(arr) - k

        while(low < high):

            mid = low + (high-low)//2
            distL = x - arr[mid]
            distH = arr[mid+k] - x
            if(distL > distH):
                low = mid + 1
            else:
                high = mid

        result = []
        for i in range(low,low+k):
            result.append(arr[i])

        return result