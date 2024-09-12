#50. Pow(x, n)
# Time Complexity : O(log(n))
# Space Complexity : O(log(n))
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# we call a recursive function with  x and abs(n) . In helper function we will recursive call the function with n/2 untill n become 0 which will return 0. Now we check if n is even , then return temp * temp else we will multiple temp * temp with x. Finally if n is postive simply return the result else  return 1 / result
class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n > 0:
            return self.helper(x,n)
        else:
            return 1/self.helper(x,-n)
    def helper(self,x,n):
        #base
        if n == 0:
            return 1
        temp = self.myPow(x,n//2)
        
        if int(n)%2 == 0:
            return temp*temp
        else:
            return temp * temp * x