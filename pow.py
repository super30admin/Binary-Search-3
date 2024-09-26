# time complexity: Log(n)
# leetcode:Accepted
# explintion: its more like a recursion problem.  if the power is even, you call the power function recursively with power as n/2. if the power is odd, you recursiveky cll power function with (power as n/2 )*x

# Every time you call the power function, you have the keep halving the power until n is 0
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # half=1
        if n == 0:
            return 1
        elif n < 0:
            x = 1 / x
            n = -n

        half = self.myPow(x, n // 2)
        if n % 2 == 0:
            half = half * half
        else:
            half = half * half * x
        return half

        # 2^8= (2^4)^216^2=256
        # 2^4=(2^2)^2=16
        # 2^2=(2^1)^2=2^2=4
        # 2^1=(2^0)^2 * 2 (power is 1-->odd) 1^2*2=2
        # 2^0=1 (n=0, base case)
