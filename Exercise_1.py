#Time Complexity : O(logN), N being n.
#Space Complexity : O(logN), N being n.
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : I got a overflow error when I used exponential instead of 
#multiplying by itself. Had to google and look at solution to figure it out.  
#Your code here along with comments explaining your approach in three sentences only
'''Using recursion, cut the problem in half, and multiply the result by itself. 
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        #taking care of the negative case. 
        if n<0:
            return 1/self.myPow(x,-n)
        else:
            #base case. 
            if n<=1:
                half = int(n/2)
                mod = n%2
                return ((x**half)**2)*x**mod
            else:
                #recursion
                half = int(n/2)
                mod = n%2
                result = self.myPow(x, half)
                return (result*result)*x**mod
        