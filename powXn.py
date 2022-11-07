"""
Approach --
TC - O(log n) --> since we're doing n/2
SC - O(log n) --> since internal recursive stack is used
"""


class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0: return float(1.0)
        # logic
        result = self.myPow(x, n / 2)

        if n % 2 == 0:
            return result * result
        elif n > 0:
            return result * result * x
        else:
            result(result * result * (1 // x))
