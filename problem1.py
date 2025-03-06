'''
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0: return 1
    
        res = self.myPow(x, abs(n) // 2)
        if n < 0:
            res = 1 / res
        if n % 2 != 0:
            if n > 0:
                return res * res * x
            else:
                return (res * res) / x
        
        return res * res