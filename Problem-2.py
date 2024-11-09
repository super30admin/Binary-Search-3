#Approach
# divide the half every time and recurse rhe half if it is even then recusion result * result elsle number *nnresult*resukt


#Complexities
# Time: O(Logn)
# Space (O(logN))

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1

        if n < 0:
            x = 1 / x
            n = -n
        result = self.myPow(x, n // 2)

        if n % 2 == 0:
            return result * result
        else:
            return result * result * x

