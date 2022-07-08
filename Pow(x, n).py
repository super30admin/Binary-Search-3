# time complexity is log(n), where n is the size of the input
# space complexity is o(1)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if(n == 0):
            return 1
        res = self.myPow(x, abs(n)//2)
        # if( n < 0):
        #     k = math.ceil(n/2)
        # else:
        #     k = n//2
        # res = self.myPow(x, n//2)
        if(n % 2 == 0):
            res = res * res
        # elif(n < 0 and n%2 == 1):
        #     res = res * res * (1/x)
        else:
            res = res * res * (x)
        return res if n>0 else 1/res