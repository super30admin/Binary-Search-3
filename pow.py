'''
Time complexity : O(logn)
Space Complexity :  
    if we consider recursive stack O(logn)
    esle: O(1)

Naive way: 
    if n is negetive x = 1/x
    multiply x , n times 

'''
# recursicve Solution 
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0 : return 1
        if n == 1: 
            return x
        if  n < 0: 
            n = -n
            x = 1/x
        sub = self.myPow(x,n//2)
        if n%2 == 0:
            return sub * sub
        else:
            return sub * sub * x
        
    
# iterative Solution
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x == 0 : return 0
        if n == 0 : return 1
        if n<0 :
            n = -n
            x = 1/x
        print(n,x)
        ans = x
        while n > 1 :
            if n%2 == 0:
                ans  = ans * ans
            else:
                ans  = ans  * ans  * x
            n = n//2
        return ans
#iterative solution not passing all test cases 