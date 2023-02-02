# Time Complexity :
# O(log N)

# Space Complexity :
# O(Log N)

# Did this code successfully run on Leetcode :
#Yes

#At each point, we find x^(n/2) and multiply it by itself. If n is add, we also multuply the product by x itself
#In case n, is negative and odd, instead of multiplying the product by itself, we multiply it by (1/x)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0 :
            return 1

        result = self.myPow(x,int(n/2))
        if n % 2 == 0 :
            return result * result
        elif n % 2 != 0 :
            if n > 0 : 
                return result * result * x
            else :
                return result * result * (1/x)
