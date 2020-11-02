#Time Complexity: O(logN + K)
#Space Complexity: O(k)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int):
        ind = bisect_left(arr, x)
        
        if ind <= 0: return arr[:k]
        if ind == len(arr): return arr[-k:]
        
        if arr[ind]==x: i, j = ind-1, ind+1
        else: i, j = ind-1, ind
        
        while j-i != k+1:
            if i==-1: j += 1
            elif j == len(arr): i -= 1
            elif x-arr[i] <= arr[j]-x: i -= 1
            else: j += 1
        
        return arr[i+1:j]