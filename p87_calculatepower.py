"""
https://leetcode.com/problems/powx-n/
TC : ologn
sc" if recursive stack is concerned o logn
:return
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        """The below O(n) solution will fail time limit exceeded"""
        ##cornercase if power<0
        # if n<0:
        #     x=1/x
        #     n=-n
        # result=1
        # for i in range(n):
        #     result*=x
        # return result
        """
        O(logn) solution below
        """
        ##base
        if n == 0:
            return 1

        ##logic
        result = self.myPow(x, int(n / 2))
        if n % 2 == 0:
            return result * result
        else:
            if n > 0:
                return result * result * x
            else:
                return result * result * (1 / x)







