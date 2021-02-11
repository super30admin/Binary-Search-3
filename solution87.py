#Time Complexity:O(nlogn)
#Space Complexity:O(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        temp=self.myPow(x,int(n/2))                     #recursively call myPow and reduce n by 2
        if n%2==0:                                      #if n is even return temp*Temp else return Temp*temp*x depending on positive and negative values of n
            return temp*temp
        else:
            if n<0:
                return temp*temp*(1/x)
            else:
                return temp*temp*x