'''
Time Complexity: O(log(n))
Space Complexity: O(log(n)) Stack Space
Run on Leetcode: YES
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base
        if n == 0:
            return 1
        if n == 1:
            return x
        if n == -1:
            return 1/x
        #logic
        a = int(n//2)
        if a > 0:
            re = self.myPow(x,a)
            if n % 2 == 0:
                return re * re
            else:
                return re * re * x
        else:
            if n % 2 == 0:
                re = self.myPow(x,a)
                return re * re
            else:
                re = self.myPow(x,a + 1)
                return re * re * (1/x)