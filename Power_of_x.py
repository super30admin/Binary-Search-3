# Time Complexity : O(logn)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using binary search. Recursion. Base case is n = 0 then return 1
# If n < 0 then call the function recursively with 1/x and -n
# Check if n is even or odd. If n is even then return result * result else return result * result * x

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            return self.myPow(1/x, -n)
        result = 1
        for i in range(n):
            result *= x
        return result
#Time - O(|n|)
#Space - O(1)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n < 0:
            return 1 / self.myPow(x, -n)
        result = self.myPow(x, n//2)
        if n % 2 == 0:
            return result * result
        else:
            return result * result * x
#Time - O(log |n|)
#Space - O(log |n|)