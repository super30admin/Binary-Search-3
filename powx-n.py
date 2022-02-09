'''

TC: O(logn)
SC: O(logn)

'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        
        
        half = self.myPow(x, int(n / 2))
        mul = half * half
        
        if n % 2 == 1:
            if n < 0:
                mul *= 1.0/x
            else:
                mul *= x * 1.0
        
        return mul
        
        
        