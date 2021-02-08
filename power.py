# Approach: Brute Force - Multiply the number by itself 'N' number of times
# Time - O(N)
# Space - O(1)


# Brute Force Method
class Solution:
    def myPow(self, x: float, n: int) -> float:

        val = 1
        for i in range(abs(n)):
            val *= x
                
        return val if n > 0 else 1/val
            

# Optimized Solution - Fast power recursion
# Time - O(log N)
# Space - O(N) recursive call stack
# Example --> 2^7 = (2^3 * 2^3) * 2


class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        # base case
        if n == 0:
            return 1
        
        val = self.myPow(x, int(n/2))
        
        if n % 2 == 0:
            return val * val
        
        elif n < 0:
            return val * val * (1/x)
        
        else:
            return val * val * x
        