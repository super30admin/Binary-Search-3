#Time Complexity: O(logn)
#Space Complexity: O(logn)
#Successfully ran on leetcode

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1.0
        result = self.myPow(x,int(n/2))
        if n%2==0:
            return (result*result)
        else:
            if n<0:
                return (result*result*1/x)
            else:
                return (result*result*x)
        