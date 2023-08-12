#Time Complexity :O(log(n-k))
#Space Complexity :O(1) #without considering output O(k)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low=0
        high=len(arr)-k
        print(low,high)
        while low<high:
            mid=int(low+(high-low)/2)
            distL=x-arr[mid]
            distH=arr[mid+k]-x
            if distL>distH:
                low=mid+1
            else:
                high=mid
        result=[]
        for i in range(low,low+k):
            result.append(arr[i])
        return result
        