# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:

    def myPow(self, x: float, n: int) -> float:
        def mpow(x,n):
            if n == 0 :
                return 1
            if x == 0 :
                return 0
            if x == 1:
                return 1
            res = mpow(x, n//2)

            if n%2:
                return x*res*res
            else:
                return res*res
        res = mpow(x,abs(n))
        if n>=0:
            return res
        else:
            return 1/(res)
