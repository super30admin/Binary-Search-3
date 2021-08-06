#Two Pointer
#Time Complexity:O(n)
#Space:O(1)
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # arr_dist = []
        low = 0
        high = len(arr)-1
        if len(arr)<=1:
            return arr
        
        while(high-low>=k and high<len(arr) and low>=0):
            # print
            if abs(arr[high]-x)<abs(arr[low]-x):
                low+=1
            else:
                high-=1
                
        return arr[low:low+k]