# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#finding the start index of the range
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        l = 0
        r = len(arr) - k
        m = self.helper(arr,k,x,l,r)
        return arr[m:m+k]
    
    def helper(self,arr,k,x,l,r):
        if l >= r:
            return l
        mid = (l+r)//2
        ld = x - arr[mid]
        rd = arr[mid+k] - x
        if rd < ld:
            return self.helper(arr,k,x,mid+1,r)
        return self.helper(arr,k,x,l,mid)