#  Time complexity : O(log(n))
#  Space complexity: O(1)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        result = self.myPow(x, int(n/2))
        if n%2 == 0 :
            # n is even then x^(n/2) * x^(n/2)
            return result * result
        else:
            
            if n < 0:
                #  # n is odd and negative then x^(n/2) * x^(n/2) * (1/x)
                return result * result * (1/x)
            else:
                 # n is odd then x^(n/2) * x^(n/2) * x
                return result * result * x
            
