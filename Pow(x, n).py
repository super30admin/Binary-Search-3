""""// Time Complexity : O(log(n))
// Space Complexity : O(recursion stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0:
            return 1

        # logic
        result = self.myPow(x, int(n / 2))
        if n % 2 == 0:
            return result * result
        else:
            if n < 0:
                return result * result * (1 / x)
            else:
                return result * result * (x)


#BruteForce
""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def myPow(self, x: float, n: int) -> float:
#         if n==0:
#             return 1
#         if n>0:
#             y=x

#             for i in range(n-1):

#                 x=x*y
#             return x
#         else:
#             y=(1/x)
#             for i in range((-n)+1):

#                 x=x*y
#             return x