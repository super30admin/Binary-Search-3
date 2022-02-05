# Binary-Search-3

## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)

# Time Complexity = O(logn)
# Space Complexity = O(1)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        if n<0:
            return self.myPow(1/x,abs(n))
        
        temp=self.myPow(x,n//2)    
        if n%2==0:
            return temp*temp
        else:
            return temp*temp*x
        
        

## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

# Time Complexity = O(logn)
# Space Complexity = O(1)



class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low=0
        high=len(arr)-k
        while low<high:
            mid=(low+high)//2
            a=x-arr[mid]
            b=arr[mid+k]-x
            if a>b:
                low=mid+1
            else:
                high=mid
        return arr[low:low+k]
        
        
