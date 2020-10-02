# Time Complexity - O(logn)
# Space Complexity - O(logn)
class Solution:
    def myPow(self, x, n):
        if n == 0:
            return 1.0
        
        recur = self.myPow(x, int(n/2))

        # To check for odd and even
        if n % 2 == 0:
            return recur * recur
        else:
            if n < 0:
                return recur * recur * 1/x
            else:
                return recur * recur * x
        

        