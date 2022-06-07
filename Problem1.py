class Solution:
    def myPow(self, x: float, n: int) -> float:
        self.x = x
        self.n = n 
        self.op = x ** n
    

mul = Solution()

mul.myPow(2.0000,10)
print(mul.op)