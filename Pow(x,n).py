class Solution:
    def myPow(self, x: float, n: int) -> float:
        #base case
        if (n==0):
            return 1.0
        #logic
        result=self.myPow(x,int(n/2))
        if(n%2==0):
            return result*result

        else:
            if(n<0):
                return result*result*1/x

            else:
                return result*result*x


s=Solution()
print(s.myPow(2.00000, 10))