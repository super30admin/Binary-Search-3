# Time Complexity : Add - O(log N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. using divide and conquer id power is an even number it can be splitted into 2, by dividing by 2
2. If power is odd, it can be split into two multiplied by x
'''

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
#         if x == 0.0:
#             return 0.0
        
        if n == 0:
            return 1
        
        temp = self.myPow(x, int(n/2))
        if n%2 == 0:
            return temp * temp
        
        else:
            if n > 0:
                return x * temp * temp
            else:
                return 1/x * temp * temp