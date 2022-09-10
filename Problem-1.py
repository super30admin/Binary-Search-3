#  50. Pow(x, n)
'''
Leetcode all test cases passed: Yes
class Solution:
    def myPow(self, x: float, n: int) -> float:
      Time Complexity: O(log n)
      Space Complexity: O(log n)
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        if n < 0:
            x = 1/x
            n = -n
        return x*pow(x,n-1)
