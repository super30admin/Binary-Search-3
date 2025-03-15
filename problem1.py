# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
class iterSolution:
    def myPow(self, x: float, n: int) -> float:
        res = 1
        
        if n < 0:
            x =  1/x
            n = abs(n)

        while n > 0:
            if n%2 == 1:
                res *= x
            x *= x
            n //= 2
        
        return res

# Time Complexity : O(logn)
# Space Complexity : O(logn)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
class recSolution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1/x
            n = abs(n)
        
        return self.recurse(x,n)
    
    def recurse(self, x,n):
        if n == 1:
            return x
        if n == 0:
            return 1
        
        res = self.recurse(x, n//2)
        if n % 2 == 0:
            return res * res
        else:
            return res * res * x