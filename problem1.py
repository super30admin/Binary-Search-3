# Time Complexity : O(Log(n))
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def myPow(self, x: float, n: int) -> float:
        print(x, n)
        if n == 0:
            return 1

        if n > 0:
            powe = n // 2
        else:
            powe = -(-n // 2)

        res = self.myPow(x, powe)

        if n % 2 == 0:
            return res * res

        else:
            if n > 0:
                return res * res * x
            else:
                return res * res * 1 / x


