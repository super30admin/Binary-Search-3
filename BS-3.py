# Binary-Search-3

## Problem 1 Pow(x,n) (https://leetcode.com/problems/powx-n/)

class Solution:
    def __init__(self):
        self.isNegative = False

    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n<0:
            self.isNegative = True
            n = n*-1
        result = self.myPow(x, n//2)
        if n%2 ==0:
            return result*result
        else:
            if self.isNegative == False:
                return result*result*x
            else:
                return result*result*1/x
            
#TC= O(log n); SC= O(log n) #because recursive calls take stack space

## Problem 2 Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if arr == None or len(arr) == 0:
            return []
        result = []
        left = 0
        right = len(arr)-1
        while right - left + 1 > k:
            distLeft = x - arr[left]
            distRight = arr[right]-x
            if distLeft > distRight:
                left = left + 1
            else:
                right = right -1
        for i in range(left, right+1):
            result.append(arr[i])
        return result
#TC= O(n); SC= O(1)