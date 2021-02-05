# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


class Solution:
    def myPow(self, x: float, n: int) -> float:
        """
        Check the exponent if it's + or - (IMPORTANT when what to recurse)
        Half the exponent every time.
        """

        if n == 0:
            return 1
        
        if n < 0:
            return self.myPow(1/x, n*-1)
       
        temp = self.myPow(x, n//2)
        
        if n % 2 == 0:
            return temp * temp
        else:
            # if n < 0:
            #     return temp*temp*(1/x)
            # else:
                return temp*temp*x