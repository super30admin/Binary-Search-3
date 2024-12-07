"Time Complexity is O(log n)"
"Space Complexity is O(1)"


#Explanation
"1. Start with `result = 1` and `current_product = x`.  
"If `n` is odd, multiply `result` by `current_product` to account for the remaining power.  
"Square `current_product` to efficiently handle the next power of 2, and halve `n`.  
"Repeat until `n` is 0, and return `result` as the final answer."

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        
        if n < 0:
            x = 1 / x
            n = -n
        
        result = 1
        current_product = x

        while(n > 0):
            if n % 2 == 1:
                result = result * current_product
            current_product = current_product * current_product
            n = n //2
        
        return result

        