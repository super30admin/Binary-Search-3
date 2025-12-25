# https://leetcode.com/problems/powx-n/

# Time Complexity- O(log n) Space Complexity- O(log n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # define the base case for recursion when n is negative
        if n < 0:
            x = 1 / x 
            n = -n


        # define the base case for recursion
        if n == 0:
            return 1

        # recursivly call the function by making the given power in half
        re = self.myPow(x, n // 2)

        # if n is even
        if n % 2 == 0:
            return re * re
        else:
            # if n is odd
            return re * re * x


solution = Solution()
print(solution.myPow(2,3))