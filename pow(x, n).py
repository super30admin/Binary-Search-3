# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
#
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0:
            return 1
        # logic
        result = self.myPow(x, int(n/2))
        if n % 2 == 0:
            return result * result
        else:
            if n > 0:
                return result * result * x
            else:
                return result * result * (1/x)


print(Solution().myPow(2, 4))

# TC: O(n); SC: O(1)
# class Solution:
#     def myPow(self, x: float, n: int) -> float:
#         result = 1
#         count = 1
#         if n < 0:
#             while count <= -1*n:
#                 result /= x
#                 count += 1
#         else:
#             while count <= n:
#                 result *= x
#                 count += 1
#         return result
#
#
# print(Solution().myPow(2, 4))