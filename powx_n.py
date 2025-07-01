class Solution:
    def myPow(self, x: float, n: int) -> float:


        ### RECURSIVE SOLUTION
        """
        TC: O(log n)
        AS: O(log n) > due to recursive stack
        """
        # base
        if n == 0:
            return 1

        # logic 
        if n < 0:
            x = 1/x
            n = -n

        res = self.myPow(x, n//2)

        if n%2 != 0:
            return res * res * x
        else:
            return res * res
        
    # def myPow(self, x: float, n: int) -> float:
        ## ITERATIVE SOLUTION
        # """
        # TC: O(log n)
        # AS: O(1)
        # """
        # if n == 0:
        #     return 1

        # if n < 0:
        #     x = 1/n
        #     n = -n

        # res = 1
        # while n != 0:
        #     if n%2 != 0:
        #         res = res * x

        #     x = x * x
        #     n = n//2
        # return res
            
