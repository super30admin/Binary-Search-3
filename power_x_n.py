#Leetcode 50 Power(x,n) https://leetcode.com/problems/powx-n/

class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        # if n is 0, any number to the power of 0 is 1
        if n == 0:
            return 1
        # if n is negative, 1/x and convert negative n to positive n by multiplying with -1
        if n < 0:
            return self.myPow(1/x, -n)
        # if n is even, n/2, temp * temp. storing result in temp, less recurrsive call
        elif n%2 == 0:
            temp = self.myPow(x, n/2)
            return temp*temp
        # if n is odd: x* function(x,n-1)
        else:
            return x*self.myPow(x, n-1)
        
        #TC: O(log N) SC: O(1)