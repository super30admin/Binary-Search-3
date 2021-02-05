class Solution:
    #Solution 1
    def myPow(self, x: float, n: int) -> float:
        #Approach: Recursion
        #Time Complexity: O(log n)
        #Space Complexity: O(log n)     //recursion stack
        
        #base
        if n == 0:
            return 1
        
        #logic
        temp = self.myPow(x, int(n / 2))
        if n % 2 == 0:
            return temp * temp
        else:
            if n < 0:
                return temp * temp * (1/x)
            else:
                return temp * temp * x
        
    #Solution 2
    """
    def myPow(self, x: float, n: int) -> float:
        #Approach: Brute Force
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        
        result = 1
        for i in range(abs(n)):
            result *= x
            
        return result if n > 0 else 1/result
    """