'''
Approach 2: Iterative solution

'''

class Solution:
    def myPow(self, x: float, n: int) -> float:
        ans = 1
        if n < 0:
            flag = -1
        else:
            flag = 1
        
        n = abs(n)
        while n != 0:
            if n%2 == 0:
                x = x*x
                n = n//2
            else:
                ans = ans*x
                n = n-1

        if flag == -1:
            return 1/ans
        return ans


'''
Approach 1: Recursive

TC: O(log(n))
SC: O(log(n))


'''


class Solution:
    def myPow(self, x: float, n: int) -> float:
        powe = n
        def power(x , n):
            if n == 0:
                return 1
            res = 1 if n%2 == 0 else x
            powVal = power(x, n//2)
            return res * powVal * powVal
        
        
        if n < 0:
            powe = -powe
            x = 1/x
  
        return power(x, powe)
        
        