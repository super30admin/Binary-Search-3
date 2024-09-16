#O(LOG(N)) TIME AND 0(1) SPACE

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x = 1 / x
            n = -n
        current_product = x
        final_product = 1
        i = n
        while i > 0:
            if i % 2 == 1:
                final_product *= current_product
            current_product *= current_product
            i = i // 2
        return final_product
            
            
        