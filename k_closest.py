# // Time Complexity : O(n) where n is the power
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # diff = [abs(x-arr[i]) for i in range(len(arr))]
       
        low = 0
        high = len(arr)-1
        
        while low < high:
            
            # print(low,high)
            if high-low+1 == k: break
            diff_low = abs(x-arr[low])
            diff_high = abs(x-arr[high])
            if diff_low > diff_high: 
                low += 1
            else: high -= 1
                
        res = []
        for i in range(low,low+k):
           
            res.append(arr[i])
        return res