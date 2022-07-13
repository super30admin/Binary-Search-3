class Solution:
    def myPow(self, x: float, n: int) -> float:
        N = n
        if N < 0:
            x = 1 / x
            N = -N
        return self.fastPow(x, N)

    def fastPow(self, x, n):
        if n == 0:
            return 1.0
        result = self.fastPow(x, int(n / 2))
        if n % 2 == 0:
            return result * result
        else:
            return result * result * x

    '''
        # Fast Power
        # base
        if n == 0:
            return 1

        # logic
        result = self.myPow(x,int(n/2))
        if n%2 == 0: #n is even
            return result*result

        else: # n is odd
            if n <0:
                return result*result*(1/x)
            else: #n>0
                return result*result*(x)
    '''

    '''
        # Also brute force - Time limit exceeded 
        # TC O(n)
        # SC O(1)

        if n <0:
            x = 1/x
            n = -n
        ans = 1
        for i in range(n):
            ans = ans * x
        return ans
    '''
    '''
        #Brute force - Maximum depth of recursion (996) exceeded for input (0.00001, 2147483647)
        if not n:
            return 1.0
        if n >0:
            return x*self.myPow(x,n-1)
        if n <0:
            return (1/x)*self.myPow(x,n+1)
            #return 1/(self.myPow(x,-n))
    '''


