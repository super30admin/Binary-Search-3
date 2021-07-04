# Time Complexity :average O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # low = 0
        low = 0
        #give high k places as worst case
        high = len(arr) - k
        # normal binary search
        while low < high:
            #get mid
            mid = low +(high-low)/2
            # as we are getting ranges get distance from mid and distance from mid +k
            distL = abs(x-arr[mid])
            distH = abs(x-arr[mid+k])
            #if there is duplicates
            if arr[mid] == arr[mid+k]:
                #if x > mid this means that the result we need is left of mid
                if x > arr[mid]:
                    low = mid +1
                # else is is right of mid
                else:
                    high = mid
            else:
                # if no duplicates if distance from mid is greater than distance from mid+k this means the anser is right of mid
                if distL > distH:
                    low = mid+1
                # else left of mid
                else:
                    high = mid
        return arr[low:low+k]
                

# Time Complexity :average O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        # low at beggining
        low = 0
        # high at end
        high = len(arr)-1
        # while the difference between low and high is the same as k
        while high-low > k-1:
            # get distance from low and high
            difflow = abs(x - arr[low])
            diffhigh = abs(x - arr[high])
            # move the one with the biggest distance
            if difflow > diffhigh:
                low +=1
            else:
                high -=1
        # return range from low to high
        return arr[low:high+1]