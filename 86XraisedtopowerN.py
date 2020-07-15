"""
// Time Complexity :O(log n) reduced the computation to half
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA
// Explanation:
    notice how the computation has been reduce without calculating the mid
    remember binary search as reducing the search space, solving using mid is one of the type
    divide the n by 2 in each recursive call
    if n is even, not need to multiply by x
    else multiply temp by x. also handle the negative n(power) case
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # base
        if n == 0:
            return 1

        # logic
        temp = self.myPow(x,int(n/2))
        if n%2 == 0 :
            return temp * temp
        else:
            if n < 0:
                return temp * temp * (1/x)
            else:
                return temp * temp * x
