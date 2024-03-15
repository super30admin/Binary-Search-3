'''
Time Complexity - O(log(exp))
Space Complexity - O(log(exp)) recursive stack space

Code works on Leetcode
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        val = self.getRes(x, abs(n)) #we get the value for the positive exponent, if exponent is negative, final result will be 1/result
        return float(val) if n>=0 else 1/val


    def getRes(self, parent, exp):
        if exp == 0:
            return 1 #anyting ^0 =1
        elif exp%2==0:
            return self.getRes(parent*parent, exp//2) #x^(2*exp/2)
        else:
            return parent*self.getRes(parent*parent, (exp-1)//2) #x*x^(2*exp-1/2)

        