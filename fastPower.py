# Iterative:
# TC O(log n)
# SC O(1)
class Solution:
    def myPow(self, x, n):  # 2 10
        ans = 1
        # if pow is -ve , cur = 1/x
        cur = x if n > 0 else 1/x    # 2
        # if pow is -ve, n = -1 * n because we run loop while n >=1 or n > 0, if power was negative it will never enter the loop
        n = n if n > 0 else -1 * n  # 10
        while n >=1:  # true (10>=1)  true(5>=1)  true (2>=1) , true(1>=1)
            if n % 2 == 1:  # false(10%2 ==0) true(5%2==1)  false(2%2==0), true(1%2==1)
                ans = ans * cur  # 1*4 = 4 , 4*256 = 1024
                if n == 1: # as we no longer care to calculate any further
                    break
            cur = cur * cur  # 2*2 = 4, 4*4 = 16, 16*16 = 256
            n = int(n/2)  # 10/2 =5 5/2 = 2, 2/2 = 1
        return ans

# Recursive:

class Solution:
    def myPow(self, x, n):
   

        # base 
        if n == 0:
            return 1.000
        
        # logic
        r = self.myPow(x, int(n/2))
        if n % 2 == 0:
            return r * r
        else:
            if n > 0:
                return r * r * x
            return r * r * 1/x