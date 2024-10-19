'''
1. We can divide a problem into subproblems to reduce the number of calls logarithmcally
2. Using the helper function, we reduce the exponent to half at each step, reusing the result at each step so we compute only logn times.

TC: O(log n)
SC: O(log n) -> Recursion stack
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0 or x==1:
                return 1

        def helper(x,n):

            if n == 0:
                return 1

            ans = helper(x,n//2)
            return ans*ans if n%2==0 else  x*ans*ans 
        
        return helper(x,n) if n>0 else 1/helper(x,-n)