# Time Complexity: O(log(n - k))
# Space Complexity: O(k)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        if (len(arr) == k):
            return arr
        else:
            n = []
            for i in range(len(arr)):
                l = []
                c = abs(arr[i] - x)
                l.append(c)
                l.append(arr[i])
                n.append(l)
            n.sort()
            m = []
            for i in range(k):
                m.append(n[i][1])
            m.sort()
            return m