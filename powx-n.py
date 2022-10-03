# // Time Complexity : Log(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach
#Comments written in every step

class Solution:
    def myPow(self, x: float, n: int) -> float:
        def helper(x,n):
            #Base case If number is 0 return 0
            #If exponent is 0 return 1
            if x==0: return 0
            if n==0: return 1
            
            #Recursion by diving the exponent by2
            res=helper(x,n//2)
            
            #Storing the result in res
            res=res*res
            
            #If n is odd then we need to multiply by x one more time
            if n%2!=0:  
                return x*res
            
            #If not then we just return the res
            else:
                return res
        
        #if the n is negative make it 1/res else normal so take the abs value of it
        res=helper(x,abs(n))
        return res if n>0 else 1/res