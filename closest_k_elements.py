#Time Complexity :  O(log(n-k) +k)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l = 0
        h = len(arr)-k
        while(l<h):
            mid = l+(h-l)//2
            left_d = x - arr[mid]
            high_d = arr[mid+k]-x
            
            if left_d > high_d :
                l=mid+1
            else:
                h = mid
        print(l,h)
        return [arr[i] for i in range(l,l+k)]
        