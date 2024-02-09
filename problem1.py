#Time Complexity :  O(log n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : yes


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        ans = 1.0
        if n < 0:
            n = -1 * n 
        
        while n > 0:
            if n % 2 == 0:
                x = x * x
                n = n/2
            else:
                ans *= x
                n = n - 1

        if n < 0:
            ans = 1.0/ans
        return ans       