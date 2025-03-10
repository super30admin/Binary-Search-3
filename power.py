class Solution:
    #TC:O(logN)
    #Sc - O(1)

    def myPow(self, x: float, n: int) -> float:
        # base case
        if n ==0:
            return 1.0
        if n < 0:
            x = 1 / x
            n = -n    
        ## Logic 
        y = self.myPow(x, n//2)
        if n%2 == 0:
            return y*y 
        else:
            return y*y*x
          

        