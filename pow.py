class RecursiveSolution:
# Iterative Approach
# TC: O(logn)
# SC: O(logn) due to recursive stack space
    def myPow(self, x: float, n: int) -> float:
        # base case
        if n ==0:
            return 1
        if n < 0:
            x = 1/x
            n = -n
        # recursion
        res = self.myPow(x,n//2)

        if n%2 == 0: # even case:
            return res * res
        else: # odd case
            return res * res * x

class IterativeSolution:
# Iterative Approach
# TC: O(logn)
# SC: O(1)
    def myPow(self, x: float, n: int) -> float:
        result = 1
        if n < 0:
            x = 1/x
            n =-n
        while n != 0:
            if n%2 !=0: # odd
                result = result* x
            n = n//2
            x = x*x
        return result