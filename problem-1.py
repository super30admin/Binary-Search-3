# Time Complexity: O(logn)
# space complxity: O(1)
# Leetocode Execution: YES
class Solution:
    def myPow(self, x: float, n: int) -> float:
#         base case to if n==0
        if n==0:
            return 1
        # logic case
        # dividing problem into sum problems reducing the computations by 2 
        result=self.myPow(x, abs(n)//2)
        # check if n is greater do this for all sub cases  
        if n>0:
            # if even computer result*result else result*result*x also in odd case
            if n%2==0:
                return result*result
            else:
                return result*result*x
        # this becomes true only in  the top most layer in recursion as we are doing abs in recursion
        else:
            if n%2==0:
                return 1/(result*result)
            else:
                return 1/(result*result*x)
                