# Time: O(logn)
# Space: recursive stack

class Solution:
    def myPow(self, x: float, n: int) -> float:
        return self.helper(x, n)
        
        
        
    def helper(self, num, power):
        if power == 0:
            return 1
        
        res = self.helper(num, int(power/2))
        
        if power % 2 == 0:
            return res * res
        else:
            if power < 0:
                return res * res * (1/num)
            else:
                return res * res * num