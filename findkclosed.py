# Approach: Two Pointer 
# Time: O(n)
# space: O(n)

class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        result = []
        
        if not arr or len(arr) == 0:
            return result
        
        low = 0
        high = len(arr) - 1
        
        while (high - low + 1 > k):
            distL = abs(x - arr[low])
            distR = abs(x - arr[high])
            
            if distL > distR:
                low += 1
            else:
                high -= 1
                
        for i in range(low, high+1):
            result.append(arr[i])
        return result
        
        
# Approach 2
# Binary Search 
# Time: O(log n)
# space: o(1)


class Solution:
    def findRangeBS(self, arr: List[int], x: int) -> tuple:
        low = 0
        high = len(arr) - 1

        # iterate till low doesn't meet high
        while (low + 1 < high):

            mid = (high - low) // 2   
            #  if x is present in the array, return the index as [low, high]
            if (x == arr[mid]):            
                return (mid, mid)
             # if x is less than mid elem, move high to mid
            elif (x < arr[mid]):           
                high = mid
            # if x is greater, move low to mid
            else:                         
                low = mid
        #   return the [low, high] as the final range when out of the loop
        return (low, high)                     
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        #   initializations
        cnt = 0; n = len(arr)
        left, right = self.findRangeBS(arr, x)

        #   if x present in the array, move left and right by 1 and increment the count
        if (left == right):
            cnt += 1
            left -= 1
            right += 1

        #   move left and right pointers until count is k
        while (cnt < k):
            if (left >= 0 and right < n):               #   if left and right are in array bounds
                if (x - arr[left] <= arr[right] - x):   #   if left elem is closer to x compared to right elem
                    left -= 1
                else:                                   #   if right elem is closer to x compared to left elem
                    right += 1

            elif (left < 0):                            #   if left elem is out of bounds
                right += 1

            else:                                       #   if right elem is out of bounds
                left -= 1

            cnt += 1

        return arr[left + 1: right] 
            +++++
