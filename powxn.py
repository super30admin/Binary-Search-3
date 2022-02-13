# tc : O(logn)
# sc : O(n)

class Solution:
    mem = dict()
    def myPow(self, x: float, n: int) -> float:
        # base cases
        
        
        if n == 0:
            return 1
        if n < 0 :
            return 1/(self.myPow(x, -1*n))
        
        # recursion
        if n%2 == 0:
            if n/2 not in self.mem :
                temp = self.myPow(x, n/2)
                self.mem[n/2] = temp
                return temp*temp
            else:
                return self.mem[n/2]*self.mem[n/2]
        else:
            return self.myPow(x, n-1) * x
