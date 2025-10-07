'''
Solution: Recursion 
    - We halve the power for every recursive call.
    - if even power, we return value returned from recursive call squared
    - if odd power, we return value return from recursive call squared multiplied
        - by num - if power>0
        - by 1/num - if power<0
Time Complexity: O(log n), n = power, we halve the power each recursive call
Space Complexity: O(log n), recursive stack
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x ==0: 
            return 0
        return self.helper(x,n)

    def helper(self,num,power):
        # base
        if power==0:
            return 1

        # logic
        if power%2==0: # even
            value = self.helper(num,int(power/2)) 
            return value*value
        else: # odd
            if power<0: # negative power
                value = self.helper(num,int(power/2))
                return value*value*(1/num)
            else:
                value = self.helper(num,int(power//2))
                return value*value*num