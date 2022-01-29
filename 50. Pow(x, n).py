# time complexity: O(logn)
# space complexity: O(logn)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base
        if n==0: return 1
        
        #logic
        result= self.myPow(x, int(n/2))
        
        if n%2==0:
            return result*result
        else:
            if n>0:
                return result*result*x
            else:
                return result*result*(1/x)