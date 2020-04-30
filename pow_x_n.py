"""
// Time Complexity : O(logn) 
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Idea comes from the fact that xn = (xn/2)^2. So essentially we divide n by 2 in 
each recursion call until we hit 0 returning 1
For odd value of n - we multiply square of ret val * x
else we multiply square of ret val * 1

For negtive n, we just erturn 1/return value from recn fn(passed -n)
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        def recn(x,n):
            if n == 0:
                return 1

            ret_val = float(recn(x,n//2))

            if n % 2:
                # if n < 0:
                #     return ret_val * ret_val * (1/x)
                return ret_val * ret_val * x
            else:
                return ret_val * ret_val
        
    
        if n < 0:
            return 1/(recn( x, -n))
        return recn(x, n)