# problem 2 

# https://leetcode.com/problems/find-k-closest-elements/

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low = 0 
        high = n-k 
        while low<high:
            mid = low + (high-low)//2
            s_val = x - arr[mid]
            e_val = arr[mid+k] - x
            if s_val > e_val:
                low = mid+1
            else:
                high = mid
        op_arr = []
        for i in range(low,low+k):
            op_arr.append(arr[i])
        return op_arr

