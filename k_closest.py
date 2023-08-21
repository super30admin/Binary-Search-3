# Time Complexity :O(N)
# Space Complexity :O(K)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l=0
        h=len(arr)-1

        while(h-l+1>k):
            # if(h-l+1==k):
            #     break
            d1=abs(arr[l]-x)
            d2=abs(arr[h]-x)

            if(d1>d2):
                l+=1
            else:
                h-=1
        return arr[l:k+l]