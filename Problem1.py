class Solution:
    
    """
    Description: Implement function which calculates x raised to power n
    
    Time Complexicity: O(log n)
    Space Complexicity: O(1)
    
    Approach:
    - Call the same function recursively for n/2
    - depending on n is odd or eve -> multiply the call by x
    - depending on n is -ve or +ve -> multiply by 1/x or x respectively
    """
    
    def myPow(self, x: float, n: int) -> float:
        
        if n == 0: return 1
        
        result = self.myPow(x, int(n/2))
        if n % 2 == 0:
            result = result * result
        elif n < 0: 
            result = result * result / x
        else: 
            result = result * result * x
                
        return result
