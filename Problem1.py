'''

Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

We use recursion to compute the power. We recursively divide the power by two and do the calculation. We also cleverly handly the case
where powers can be both odd or even

'''


class Solution:
    def myPow(self, x: float, n: int) -> float:
        neg = False
        if n < 0:
            neg = True
            n *= -1

        def pow(x,n):
            if n == 0:
                return 1

            if n % 2 == 0:
                res = pow(x*x, n//2)
                return res
            else:
                res = pow(x*x, n//2)
                return res*x

        if neg:
            return 1/pow(x,n)
        else:
            return pow(x,n)