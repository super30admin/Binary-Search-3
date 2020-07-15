#Time Complexity : O(logn) because we are dividing the value of n into half
#SPace complexity:O(1)
#Ran successfully on Leetcode:yes

#Algorithm:
#When the value of n is even we just return temp^2
#If its odd we have to check for the n value if n < 0 then return temp^2*1/x else return temp^2

class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base
        if n ==0:
            return 1
       
        
        
        #logic:
        temp=self.myPow(x,int(n/2))
        if n%2==0:
            return (temp*temp)
        else:
            if n<0:
                return temp*temp*(1/x)
            else:
                return (temp*temp*x)
