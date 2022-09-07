class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.00
        # print(n / 2, int(n / 2))
        result = self.myPow(x, int(n / 2))

        # print(n/2, int(n))
        if n % 2 == 0:
            return result * result
        else:
            if n > 0:
                return result * result * x
            else:
                return result * result * (1 / x)


# TC =O(logn). Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
"""
# Any problem you faced while coding this : Yes, 
I was not converting n/2 to  int on line 6 i.e result = self.myPow(x, int(n / 2)). Now it works.
"""
