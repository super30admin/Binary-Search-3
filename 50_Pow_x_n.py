# Time Complexity : O(log n) [n = input given]
# Space Complexity : O(log n) [stack space used]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
import math
class Solution:
    def myPow(self, x: float, n: int) -> float:
        ## base
        if n == 0:
            return 1
        
        ## body

        # if n == 1 then (n/2) should be 0 so we use floor
        # if n == -1 then (n/2) should be 0 so we use ceil
        power  = math.floor(n / 2) if n > 0 else math.ceil(n/2)  
        res = self.myPow(x, power)
        if n % 2 == 0:
            return res * res
        else:
            if n < 0:
                return res * res * ( 1 / x)
            else:
                return res * res * (x)