-------------------------------- X raised to the power of n ---------------------------------------------
# Time Complexity : log n
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# First I will do this recursively, where I am calling recursive function by making my n as n/2 as we have a property x^n/2*x^n/2
# provides me the x^n. With this I can recursively call function , but when my n is odd, I will multiply the x to my temporary answer I got from the previous call.


------- Recursively----------
class Solution:
    def myPow(self, x: float, n: int) -> float:
        i = n
        if i<0:
            i = i*-1
        curr = x
        ans = 1
        while i>0:
            if i%2 == 1:
                ans = ans*curr

            curr = curr*curr
            i = i//2
        if n<0:
            return 1/ans
        else:
            return ans
            
--------------- iteratively---------------

#I used same approach in iteratively, when I am encountering odd n, I am multiplying one extra curr element to my ans.         
class Solution:
    def myPow(self, x: float, n: int) -> float:
        i = n
        if i<0:
            i = i*-1
        curr = x
        ans = 1
        while i>0:
            if i%2 == 1:
                ans = ans*curr

            curr = curr*curr
            i = i//2
        if n<0:
            return 1/ans
        else:
            return ans
            

    