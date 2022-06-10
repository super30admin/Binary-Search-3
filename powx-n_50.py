#Approach: dfs everytime divinding power
#Time Complexity O(logN)
#Space Complexity O(1)
#It successfully runs on leetcode

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0: return 1
        if n<0: n, x = -n, 1/x   
        res = self.myPow(x,n//2)
        return res * res * x if n % 2 else res * res