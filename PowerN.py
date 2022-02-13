'''
Solution:
1.  To calculate pow(x, n), instead of performing a linear computation by multiplying x from 1 to n times, we can
    perform binary computation by multiplying x twice in a function call to reduce the computation time to logn from n.
2.  Just need to handle the cases where n is negative and also when n is odd.
Time Complexity: O(logN) | Space Complexity: O(logN)
--- Passed all testcases successfully on leetcode
'''

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.00
        
        result = self.myPow(x, int(n/2))
        if n%2 == 0:
            return result * result
        else:
            if n > 0:
                return result * result * x
            else:
                return result * result * (1/x)