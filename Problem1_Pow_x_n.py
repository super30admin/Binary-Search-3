#Problem 1:https://leetcode.com/problems/powx-n/
#Test Cases passed on Leetcode 
#Binary Search Used
#Time Complexity-O(logn)
#Space Complexity-O(logn)
class Solution:
    def myPow(self, x: float, n: int) -> float:
      
      #base
        if n == 0:
            return 1
        #we are reducing sample space
        #for eg=3^4=3^2*3^2
        #3^5=3^2*3^2*3
        temp=self.myPow(x,int(n/2))
        #for even case
        if n%2==0:
            return temp*temp
        else:
            #for odd
            #check if n is odd  negative
            if n>0:
                return temp*temp*x
            #odd positive
            else:
                return (temp*temp)/x
            
        