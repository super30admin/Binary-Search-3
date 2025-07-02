##problem 1: iterative 

class Solution:
    def myPow(self, x: float, n: int) -> float:

        if n < 0:
            x = 1/x
            n = -n
        re = 1.0

        while n != 0:
           
            if n % 2 != 0:
                re = re * x

            x = x*x
            n = n // 2

        return re

            
##problem2

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        low = 0 
        hi = len(arr) - 1 

        while (hi - low) + 1 != k:

            diff1 = abs(arr[low]-x)
            diff2 = abs(arr[hi]-x)
            if  diff1 < diff2:
                hi-=1
            elif diff1 > diff2:
                low +=1
            else:
                hi-=1

        return arr[low:hi+1]