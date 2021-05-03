# Approach 1 - inbuilt ** operator
# TC - implemented as pow method of C - O(logn)
# SC  - O(1)  since nothing is stored
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        
        return x ** n

    
# Approach 2 - Brute Force iterate through n - got time limit exceeded
# TC - O(n)
# SC  - O(1)  since nothing is stored
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        
        print(n)
        result = 1
        
        for i in range(0, abs(n)):
            result *= x
        
        print(result)
        if n > 0:
            return result
        else:
            print(result)
            return 1/result
        
    
    
# Approah 3 - Binary search - dividing and computing 
# TC - O(log n)
# SC - O(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        
        y = self.myPow(x, int(n/2))
        
        #print("res =", y)
        if n % 2 == 0:
            return y * y
        else:
            if n < 0:
                return y * y * (1/x)
            else:
            
                return y * y * x
        
# Approach 3.b - Divide and conquer 
# TC - O(logn)
# SC - O(1) - nothing stored
class Solution:
    def inner(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        
        y = self.inner(x, int(abs(n/2)))
        
        if n % 2 == 0:
            return y * y
        else:            
            return y * y * x
        
    def myPow(self, x: float, n: int) -> float:
        result = self.inner(x, n)
        if n < 0:
            return 1/result
        return result

            