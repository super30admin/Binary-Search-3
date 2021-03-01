# // Time Complexity : O(n/2)
# // Space Complexity : O(n/2)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# use recursion. 
# divide the n by half till it reaches 0
# multiply the result and return 
# whever n is ODD:
    # AND n is negative we multiply by 1/x
    # AND n is positive we multiply by x


class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base
        if n == 0: return 1
        if n<0:
            x = 1/x
            n = -n
        #logic
        temp = self.myPow(x,n//2)
        
        if n%2 == 0:
            return temp * temp
        else:
            return temp * temp * x
        