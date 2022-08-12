# Time Complexity = O(log n), recursion
# Space Complexity = O(log n), recursive stack


class Solution:
    def myPow(self, x: float, n: int) -> float:
        # Base cases to stop the recursion
        if n == 0:
            return 1.0
        
        if n == 1:
            return x
        
        if n < 0:
            if x == 0:
                return float("inf")
            x = 1 / x
            n = -1 * n
         
        # Calling the Recursion
        result = self.myPow(x, n // 2)
        
        
        # Exmpl --> y3 = 2^7 = 2^3 * 2^3 * 2 = y2 * y2 * x
                #   y2 = 2^3 = 2^1 * 2^1 * 2 = y1 * y1 * x
                #   y1 = 2^1 = 2^0 * 2^0 * 2 = y0 * y0 * x
                
        # Exmpl --> y3 = 3^-4 = 3^-2 * 3^-2 = y2 * y2 
                #   y2 = 3^-2 = 3^-1 * 3^-1 = y1 * y1 
                #   y1 = 3^-1 = 3^0 * 3^0 * 1//3 = y0 * y0 * 1//x
        # If n is even, we simply multiply result with result
        if n % 2 == 0:
            return result * result
        
        
        else:
            # If n is odd and pos, multiply x to result * result
            if n > 0:
                return result * result * x
            # If n is odd and neg, multiply 1//x(int val) to result * result
            else:
                return (result * result * (1 // x))
            