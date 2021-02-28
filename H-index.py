# // Time Complexity : O(logn) for binary || O(n) for 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# we run binary search with target == (len(arr) - mid)  

# approach 2: we for loop through arr and find when arr[index] >= len(arr)-index and return


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or citations == []: return 0
        
        low = 0
        high = len(citations)-1
        return self.binarySearch(low, high, citations)
    
    def binarySearch(self, low, high, arr):
        n = len(arr)
        while low<=high:
            mid = (low + high)//2
            if n-mid == arr[mid]:
                return n-mid
            elif n-mid > arr[mid]:
                low = mid + 1
            else:
                high = mid-1
        return n-low
            
        
        
        
        
        
        # for i in range(len(citations)):
        #     if n-i<=citations[i]:
        #         return n-i
        # return 0