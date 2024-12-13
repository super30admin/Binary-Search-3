class Solution:
    def myPow(self, x: float, n: int) -> float:
        '''
        x = 
        '''
        def pow(x, n):
            if n == 0:
                return 1

            if n > 0:
                if n%2 == 0:
                    return pow(x*x, n//2)
                else:
                
                    
                    return x * pow(x*x, (n-1)//2)
            else:
                return 1 / pow(x, -n)
        return pow(x, n)
