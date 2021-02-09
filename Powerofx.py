# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using binary search. Recursion. Base case is n = 0 then return 1
# If n < 0 then call the function recursively with 1/x and -n
# Assign the output to temp gy calling recursively x and n//2
# Check if n is even or odd. If n is even then return temp * temp else return temp * temp * x


class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base
        if n == 0:
            return 1
        if n < 0:
            return self.myPow(1 / x, -n)
        #logic
        temp = self.myPow(x, n // 2)

        if n % 2 == 0:
            return temp * temp
        else:
            return temp * temp * x
