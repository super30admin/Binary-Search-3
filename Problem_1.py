# time complexity for this problem will be O(Log n) as we are dividing sapce in half
# space complexity - however calling stack may reach log n that is extra space O(log n)
# runs on leetcode = YES
# problems while doing this = No
class Solution:
    def myPow(self, x, n):
        # approach: recursive call n // 2 until n == 1 or -1
        # base
        if n == 0: return 1
        if n == 1: return x
        if n == -1: return 1 / x
        #recursion 
        result = self.myPow(x * x, n // 2)
        #return result
        return  result * (x if n % 2 else 1)

