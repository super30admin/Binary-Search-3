# Created by Aashish Adhikari at 7:35 PM 2/4/2021

'''
Time Complexity:
O(n)

Space Complexity:
O(1)
'''


class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """

        if len(arr) == 0:
            return []


        low = 0
        high = len(arr)-1

        while(high-low >= k):

            left_dist = abs(x - arr[low])
            right_dist = abs(x - arr[high])

            if left_dist > right_dist:
                low += 1
            else:
                high -= 1

        result = []
        for idx in range(low, high+1):
            result.append(arr[idx])

        return result