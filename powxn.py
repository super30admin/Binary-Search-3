"""50. Pow(x, n)
Time Complexity: O(log N)
Space Complexity:O(log N) """
class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base
        if n == 0:
            return 1
        #logic
        temp = self.myPow(x,abs(n)//2)
        if n%2==0:
            output = temp*temp
        else:
                output = temp*temp*x
        if n<0:
            return 1/output
        return output