class Solution:
    def myPow(self, x, n):
        if n < 0:
            x = 1 / x
            n = -n

        result = 1.0
        while n:
            if n & 1:         
                result *= x
            x *= x            
            n >>= 1           
        return result

if __name__ == "__main__":
    sol = Solution()
    print(sol.myPow(2.0, 10))   
    print(sol.myPow(2.1, 3))    
    print(sol.myPow(2.0, -2))   
