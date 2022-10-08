#Time: O(n)
#Space: O(1)
#Problem ran on leetcode without any issues

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        low = 0
        high = len(arr) - 1
        while (high - low + 1 > k):
            distStart = abs(x - arr[low])
            distEnd = abs(arr[high] - x)
            
            if (distStart > distEnd):
                low+=1
            else:
                high += -1
        
        result = []
        for i in range(low, high+1):
            result.append(arr[i])
        return result