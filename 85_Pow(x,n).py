'''
Accepted on leetcode(50)
Time - O(logN), space O(1)
Method: Call the function recursively and divide the power into half and also take case of cases when n is neagtive and odd
This is optimal solution, brute force is just iterating over the power and multiplying x in the loop.
'''
class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Base Case
        if n == 0: return 1
        print(x,n)
        # Logic
        temp = self.myPow(x, int(n/2)) # call function recursively
        if n % 2 == 0: # when power is even
            return temp*temp
        else:
            if n > 0: # when power is odd
                return temp*temp*x
            else: # when power is negative
                return temp*temp*(1/x)