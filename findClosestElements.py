#658. Find K Closest Elements
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
#assign low to 0 and high to last ele in array . Now compare the difference between target and low , high value . If diff of low is gt high then increment low else decrement high untill low and high cross each other. Finally return elements from low to low + k
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) -1
        while high - low > k-1 :
            distl = abs(x - arr[low])
            distr = abs(x - arr[high])
            if distl > distr:
                low = low + 1
            else:
                high = high - 1
        return arr[low:high+1]

# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no		
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - k
        while low < high:
            mid = low + (high - low) // 2
            distL = abs(x - arr[mid])
            distH = abs(x - arr[mid + k])
            
            if arr[mid] == arr[mid+k]:
                if x > arr[mid]:
                    low = mid + 1
                else:
                    high = mid
            else:                
                if distL > distH:
                    low = mid + 1
                else:
                    high = mid
        return arr[low:low+k]