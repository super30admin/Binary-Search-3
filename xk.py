# // Time Complexity :O(log(n-k))
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result=[]
        low=0
        high=len(arr)-k
        while(low<high):
            mid=(low+high)//2
            diss=x-arr[mid]
            dise=arr[mid+k]-x
            if(diss>dise):
                low=mid+1
            else:
                high=mid
        for i in range(low,low+k):
            result.append(arr[i])
        return result
            
        