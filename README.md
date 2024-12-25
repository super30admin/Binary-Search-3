# Binary-Search-3

## Problem1: Pow(x,n) (https://leetcode.com/problems/powx-n/)
class Solution:
    def myPow(self, x: float, n: int) -> float:

        def calc_power(x, n):
            if x == 0:
                return 0
            if n == 0:
                return 1
            
            res = calc_power(x, n // 2)
            res = res * res

            if n % 2 == 1:
                return res * x
            
            return res

        ans = calc_power(x, abs(n))

        if n >= 0:
            return ans
        
        return 1 / ans 


## Problem2: Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        low = 0
        
        high = len(arr) - k
        
        while low < high:
            
            mid = low + (high-low)//2
            
            if x<=arr[mid]:
                
                high=mid
                
            elif arr[mid+k]<=x:
                
                low = mid+1
                
            else:
                
                middist = abs(x-arr[mid])
                
                midkdist = abs(x-arr[mid+k])
                
                if middist <= midkdist:
                    
                    high=mid
                    
                else:
                    
                    low=mid+1
            
                    
        return arr[low:low+k]
