#Time Complexity: The time complexity of this algorithm is O(logn).
#Space Complexity: The space complexity is O(logn) due to the recursion stack.

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if(x==0):
            return 0
        if(n==0):
            return 1
        if(n<0):
            x = 1/x
            n = n*(-1)
        result = self.myPow(x , n//2)
        if(n%2==0):
            return result * result
        else:
            return result * result * x