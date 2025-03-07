# Problem 1 : Pow(x, n)
# Time Complexity : O(log n)
# Space Complexity : O(log n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # if n is 0 return 1 since any number raised to 0 is 1
        if n == 0 :
            return 1
        # recursively call myPow function with x and n/2. The reason for n/2 is to divide the problem into half step.
        temp = self.myPow(x, int(n/2))
        # check if n is even or odd
        if ( (n%2) == 0):
            # if n is even then just return square of the temp
            return temp * temp
        else:
            # if n is odd then check if the n is positive or negative
            if (n > 0):
                # if n is positive then return- square of temp and multiply that with x. Here x is an extra element.
                return temp * temp * x
            else:
                # if n is negative then return- square of temp and multiply that with (1/x). Here (1/x) is an extra element
                return temp * temp *(1/x)
        
